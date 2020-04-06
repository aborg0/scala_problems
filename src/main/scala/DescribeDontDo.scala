object DescribeDontDo {
  trait Order
  final case class Email private(email: String)

  trait Processor {
    def charge(order: Order)
  }
  def getConfirm(order: Order): Email = ???
  def sendEmail(email: Email): Unit = ???

  def processor: Processor = ???
  def completePurchase_Do(order: Order): Unit = {
    //
    processor.charge(order)
    val email = getConfirm(order)
    sendEmail(email)
    //
  }

  sealed abstract class PurchaseAction
  final case class Charge(order: Order) extends PurchaseAction
  final case class SendEmail(email: Email) extends PurchaseAction

  def completePurchase_Described(order: Order): List[PurchaseAction] = {
    //
    Charge(order) ::
    SendEmail(getConfirm(order)) :: Nil
    //
  }

}
