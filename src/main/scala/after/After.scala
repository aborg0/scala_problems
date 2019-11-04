package after

import scala.annotation.tailrec

object After extends App {
  def change(nums: Seq[Int], references: Seq[Int], transform: PartialFunction[(Int, Int), Seq[Int]]): Seq[Int] = {
    for {
      num <- nums
      ref <- references
      v <- transform.applyOrElse[(Int, Int), Seq[Int]]((num, ref), _ => Seq.empty[Int])
    } yield {
      v
    }
  }

  def altFold(nums: Seq[Int], references: Seq[Int], transform: PartialFunction[(Int, Int), Seq[Int]]): Seq[Int] = {
    nums.foldLeft(Seq.empty[Int])((seq, n) => {
      references.foldLeft(Seq.empty[Int])((inner, ref) =>
        inner ++ transform.lift((n, ref)).getOrElse(Seq.empty))
    })
  }

  def altRec(nums: Seq[Int], references: Seq[Int], transform: PartialFunction[(Int, Int), Seq[Int]]): Seq[Int] = {
    @tailrec
    def collect(acc: Seq[Int], restNums: Seq[Int]): Seq[Int] = {
      if (restNums.isEmpty) {
        acc
      } else {
        val head +: tail = restNums
        @tailrec
        def inner(acc2: Seq[Int], restRefs: Seq[Int]): Seq[Int] = {
          if (restRefs.isEmpty) {
            acc2
          } else {
            val refHead +: refTail = restRefs
            inner(acc2 ++ transform.lift((head, refHead)).getOrElse(Seq.empty), refTail)
          }
        }
        collect(acc ++ inner(Seq.empty[Int], references), tail)
      }
    }
    collect(Seq.empty[Int], nums)
  }

  val input = Seq(0, 1, 42)
  val reference = Seq(2, 3, 5, 7, 11)
  val divisors: PartialFunction[(Int, Int), Seq[Int]] = {
    case (nonPos, _) if nonPos <= 0 => Seq.empty[Int]
    case (a, b) => LazyList.iterate(b)(n => n * b).takeWhile(n => a % n == 0)
  }

  println(s"Before change: $input")
  val changed = change(input, reference, divisors)
  println(s"After change with for: $changed")
  println(s"After change with fold: ${altFold(input, reference, divisors)}")
  println(s"After change with recursion: ${altRec(input, reference, divisors)}")

}
