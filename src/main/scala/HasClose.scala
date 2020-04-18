trait HasClose {
  def closeIt(): Unit
}

object HasClose {
  implicit class AutoCloseableHasGet(autoCloseable: AutoCloseable) {
    def closer: HasClose = () => autoCloseable.close()
  }
}
