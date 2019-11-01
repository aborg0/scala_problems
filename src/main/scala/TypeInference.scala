sealed abstract class Result extends Product with Serializable

object Result {
  case object Ok extends Result
  case object NotOk extends Result
}

object TypeInference {
  import Result._

  def resultOf(option: Option[String]): Result =
//    option.fold(NotOk)(_ => Ok)








































    option.fold[Result](NotOk)(_ => Ok)
}
