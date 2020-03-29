package data

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.OptionValues
import org.scalatest.wordspec.AnyWordSpec

class EmailTest extends AnyWordSpec with OptionValues {
  "Email's fromString" should {
    "parse: test@example.org" in {
      assert(Email.fromString("test@example.org").value.email.value === "test@example.org")
    }
    "not parse testexample.org" in {
      assert(Email.fromString("testexample.org") === None)
    }
  }
}

object EmailTest {
  def arbitraryEmail: Arbitrary[Email] = Arbitrary(
    for {
      address <- (Arbitrary.arbString.arbitrary suchThat (v => !v.contains("@")))
      numOfHostParts <- Gen.choose(1, 8)
      host <- Gen.listOfN(numOfHostParts, Gen.alphaNumStr).map(l => l.mkString("."))
      email = Email.fromString(s"$address@$host")
      if email.isDefined
    } yield email.get
  )

  def arbitraryNonEmail: Arbitrary[String] = Arbitrary(Arbitrary.arbitrary[String] suchThat (v => !v.matches(Email.EmailRegexString)))
}
