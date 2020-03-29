sealed abstract class CachedValue[+A] extends Product with Serializable

object CachedValue {
  final case class Cached[+A](value: A) extends CachedValue[A]
  final case object NonCached extends CachedValue[Nothing]
//  final case class Uncached[A]() extends CachedValue[A]
}

trait Animal

class Dog extends Animal

object X {
  def feed(what: CachedValue[Animal]): Unit = ???
  val dog = CachedValue.Cached(new Dog)
  feed(dog)
}