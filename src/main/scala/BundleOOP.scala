trait BundleOOP {
  def initialize(): Unit = {}
}

class Activator(token: String)

class BundleOOPImpl(token: String) extends BundleOOP {
  private[this] var activator: Activator = _
  override def initialize(): Unit = {
    super.initialize()
    this.activator = new Activator(token)
  }
}
