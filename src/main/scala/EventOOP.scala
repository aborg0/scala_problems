object EventOOP {
  type ID = Int

  abstract class AbstractEvent {
    def id: ID

    def name: String
  }

  type OrderID = Int
  type OrderDetails = Seq[OrderID]

  case class PurchaseEvent(id: ID, name: String, details: OrderDetails) extends AbstractEvent

  case class RefundEvent(id: ID, name: String, orderId: OrderID) extends AbstractEvent

  def changeName[E <: AbstractEvent](event: E, newName: String): E =
    event match {
      case e: PurchaseEvent => e.copy(name = newName).asInstanceOf[E]
      case e: RefundEvent => e.copy(name = newName).asInstanceOf[E]
    }
}
