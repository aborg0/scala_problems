object Varargs extends App {
  def reverse[T](args: T*): Seq[T] = args.reverse

  val input = Seq(0, 1, 42)
  println(reverse(input))

























//  println(reverse[Int](input))





























  println(reverse[Int](input: _*))
}
