trait Numeric[A] {
  def add(l: A, r: A): A
}
object Numeric {
  def apply[A](implicit n: Numeric[A]): Numeric[A] = n
  implicit class NumericSyntax[A](l: A) {
    def +(r: A)(implicit n: Numeric[A]): A = n.add(l, r)
  }

  def sumAll[A: Numeric](l: List[A]): A = ???

  implicit def Tuple2Numeric[A: Numeric, B: Numeric]: Numeric[(A, B)] = new Numeric[(A, B)] {
    override def add(l: (A, B), r: (A, B)): (A, B) = ???
  }

  implicit val ByteNumeric: Numeric[Byte] = new Numeric[Byte] {
    override def add(l: Byte, r: Byte): Byte = ???
  }
  implicit val IntNumeric: Numeric[Int] = (l: Int, r: Int) => l + r
  implicit val DoubleNumeric: Numeric[Double] = (l: Double, r: Double) => l + r
}

class Rational(n: BigInt, d: BigInt)

object Rational {
  implicit val RationalNumeric: Numeric[Rational] = new Numeric[Rational] {
    override def add(l: Rational, r: Rational): Rational = ???
  }
}

object Y {
  val myRationals: List[Rational] = List(new Rational(BigInt(1), BigInt(2)))
  val sum: Rational = Numeric.sumAll(myRationals)
  val t2Sum: (Int, Int) = Numeric.sumAll((1, 2):: (3, 4) :: (5, 8) :: Nil)
  val t2t2Sum: (Int, (Int, Double)) = Numeric.sumAll((1, (2, 0.23)):: (3, (4, 3.1)) :: Nil)
}