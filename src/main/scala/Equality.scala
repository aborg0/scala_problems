//import org.scalactic.TypeCheckedTripleEquals._

object Equality extends App {
  val listOfLists = List(List(3))
// SeqOps: def contains[A1 >: A](elem: A1): Boolean = exists (_ == elem)
  println(listOfLists.contains(3))
//  println(listOfLists.exists(_ === 3))
}
