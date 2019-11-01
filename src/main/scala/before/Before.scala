package before

import scala.collection._
import scala.jdk.CollectionConverters._

object Before extends App {
  def change(nums: mutable.ArrayBuffer[Int], references: Seq[Int], transform: PartialFunction[(Int, Int), Seq[Int]]): Unit = {
    var newValues = mutable.Seq[Int]()
    for {
      num <- nums
      ref <- references
    } {
      newValues ++= transform.lift((num, ref)).getOrElse(Seq.empty)
    }
    nums.asJava.clear()
    nums.asJava.addAll(newValues.asJava)
  }

  val input = mutable.ArrayBuffer(0, 1, 42)
  val reference = Seq(2, 3, 5, 7, 11)
  val divisors: PartialFunction[(Int, Int), Seq[Int]] = {
    case (nonPos, _) if nonPos <= 0 => Seq.empty[Int]
    case (a, b) => var powers = mutable.Seq[Int]()
      var newB = b
      while (a % newB == 0) {
        powers :+= newB
        newB *= b
      }
      powers.toSeq
  }

  println(s"Before change: $input")
  change(input, reference, divisors)
  println(s"After change: $input")
}
