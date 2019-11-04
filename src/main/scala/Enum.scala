object A extends Enumeration {
  val A1, A2 = Value
}

object B extends Enumeration {
  val B1, B2 = Value
}

object Enum extends App {
  def a(input: A.Value): String = input.toString

  println(B.B2)
}
