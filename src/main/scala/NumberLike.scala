trait NumberLike[A] { self: A =>
  def +(that: A): A
}

class RationalNumberLike(n: BigInt, d: BigInt) extends NumberLike[RationalNumberLike] {
  override def +(that: RationalNumberLike): RationalNumberLike = ???
}

object NumberLike {
  def sumAll[A <: NumberLike[A]](l: List[A]): A = ???
}

object X {
  val myRationals = List(new RationalNumberLike(BigInt(1), BigInt(2)))
  NumberLike.sumAll(myRationals)
}
