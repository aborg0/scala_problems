object ExistentialTypeInference {
  def sth: java.lang.Iterable[_ <: CharSequence] = ???
  trait Stubbing[T] {
    def thenReturn(t: T): Unit
  }
  object Mock {
    def when[T](call: T): Stubbing[T] = ???
  }
  val res = sth
  //Mock.when(sth).thenReturn(res)







































  Mock.when[java.lang.Iterable[_ <: CharSequence]](sth).thenReturn(res)
}
