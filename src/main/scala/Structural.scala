import java.io.ByteArrayOutputStream
import java.security.Permission

// -Dsun.reflect.noInflation=true
object Structural {

  def main(args: Array[String]): Unit = {
    val manager = new SecurityManager {
      override def checkPermission(perm: Permission): Unit = {
          super.checkPermission(perm)
      }
    }
    System.setSecurityManager(manager)
    new ByteArrayOutputStream().close()
    val stream/*: {def close(): Unit}*/ = new ByteArrayOutputStream()

    import HasClose._
    stream.closer.closeIt()
//    Closer.stop(stream)
  }
}