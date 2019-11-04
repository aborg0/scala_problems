import scala.collection.immutable.List
object IsItImmutable extends App {
  private val hello = List("Hello")
  private val world = List("World")

  def nel[T](l: List[T]): Option[::[T]] = l match {
    case nel@ ::(_, _) => Some(nel)
    case _ => None
  }

  println(s"hello is: $hello, world is $world")
  for (nonEmpty <- nel(hello)) {
    Mutate.changeTail(nonEmpty, world)
  }
  println(s"hello is: $hello, world is $world")
}
