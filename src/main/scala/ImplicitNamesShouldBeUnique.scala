import java.util.regex.Pattern


object ImplicitNamesShouldBeUnique {
  trait EscapeSql {
    def escapeSql: String
  }

  object EscapeSql {
    private val QuoteRegex = Pattern.quote("'")
    def simple(str: String): EscapeSql = new EscapeSql {
      override def escapeSql: String = str.replaceAll(QuoteRegex, "''")
    }
  }

  implicit def augmentString(str: String): EscapeSql = EscapeSql.simple(str)
//  import Predef._
//  import Proper._
  def main(args: Array[String]): Unit = {
    val _ = "".escapeSql
  }

  object Proper {
    implicit final class EscapeSqlOp(val str: String) extends AnyVal {
      def escapeSql2: String = EscapeSql.simple(str).escapeSql
    }
  }
}