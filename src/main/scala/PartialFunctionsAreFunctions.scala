import scala.util.Try

object PartialFunctionsAreFunctions {
  def main(args: Array[String]): Unit = {
    Try(???).recover(_ => 1)

    List("FOO_A", "BAR_B").map {
      case s if s.startsWith("FOO_") => s
    }
  }
}