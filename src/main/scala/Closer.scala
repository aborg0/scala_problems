object Closer {
  def stop(closeable: {def close(): Unit}): Unit = {
    closeable.close()
  }
}
