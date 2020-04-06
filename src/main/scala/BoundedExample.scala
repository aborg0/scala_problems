import monocle.Prism

object BoundedExample {
  trait ProductID
  trait MovieID extends ProductID

  trait Product[T <: ProductID] {
    def id: T
    def prism: Prism[ProductID, T]
  }
  trait Movie extends Product[MovieID]

  trait NumberLike[A] {
    self: A =>
  }
  def sort[A <: NumberLike[A]](v: List[A]): List[A] = ???
  //          |
  //          | better use type classes
  //          |
  //          v
  def sort[A: Numeric/*: Ordering*/](v: List[A]): List[A] = ???
}
