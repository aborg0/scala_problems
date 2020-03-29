final case class UserProfile(name: String, postalCode: String)

object UserProfile {

}

object Y {
  def getUserProfile(id: Int): Option[UserProfile] = ???

  def lookupCountry(postalCode: String): String = ???

  def getCountryByIP(): String = ???

  val id: Int = 11
  val profile: Option[UserProfile] = getUserProfile(id)

  val countryMapGetOrElse: String =
    profile.map(p => lookupCountry(p.postalCode)).getOrElse(getCountryByIP())

  val countryFold: String = profile.fold(getCountryByIP())(//(_.postalCode).andThen(lookupCountry)
    p => lookupCountry(p.postalCode)
  )
}
