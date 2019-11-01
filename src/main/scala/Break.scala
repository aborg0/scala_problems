import scala.util.control.Breaks

object Break extends App {
  def doSomething(): Unit = {
    val bb = new Breaks

    import bb._

    breakable {
      for (i <- -1 to 4) {
        CatchAll.catchAll { () => {
//          if (i == 0) break()
//          if (i == 0) return ()
          println(s"12 / $i = ${12 / i}")
        }
        }
      }
    }
  }
  doSomething()
}
