package data

import com.google.common.annotations.VisibleForTesting
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.string._

import scala.util.matching

case class Email private(email: String Refined MatchesRegex[Email.EmailRegexString.type]) {
  def copy(email: String Refined MatchesRegex[Email.EmailRegexString.type]): Email =
    new Email(email)
}

object Email {
  @VisibleForTesting
  private[data] final val EmailRegexString = "([^@]+@\\w+(?:\\.\\w+)*)"
  private val EmailRegex: matching.Regex = EmailRegexString.r

  private def apply(email: String Refined MatchesRegex[Email.EmailRegexString.type]): Email = {
    new Email(email)
  }

  def fromString(value: String): Option[Email] = value match {
    case EmailRegex(valid) => refineV[MatchesRegex[EmailRegexString.type]](valid).toOption.map(new Email(_))
    case _ => None
  }

  def sendEmail(email: Email): Unit = ???
}
