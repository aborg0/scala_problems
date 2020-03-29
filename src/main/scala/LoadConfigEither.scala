final case class Config(host: String, port: Int)

object Config {
  lazy val Default = Config("localhost", 5432)
}

object LoadConfig {
  def loadConfig(): Either[String, Config] = ???
}

object X {
  def addOverrides(config: Config): Config = ???
  val configPatternMatch: Config = LoadConfig.loadConfig() match {
    case Left(_) => Config.Default
    case Right(config) => addOverrides(config)
  }

  val configFold: Config = LoadConfig.loadConfig().fold(_ => Config.Default, addOverrides)
}
