final case class Person(name: String, age: Int)

sealed abstract class Contact extends Product with Serializable

final case class Email(value: String) extends Contact

final case class Phone(value: String) extends Contact

object EventADT {

  type ID = Int

  final case class Event(id: ID, name: String, payload: Payload)

  type OrderID = Int
  type OrderDetails = Seq[OrderID]

  sealed abstract class Payload extends Product with Serializable

  object Payload {

    final case class Purchase(details: OrderDetails) extends Payload

    final case class Refund(orderID: OrderID) extends Payload

  }

  def changeName(event: Event, newName: String): Event = event.copy(name = newName)
}
