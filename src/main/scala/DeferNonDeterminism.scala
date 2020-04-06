import scala.concurrent.duration._
import scala.util.Random

object DeferNonDeterminism {
  trait Task

  def schedule(task: Task, waitDuration: Duration): Unit = ???

  def retryLater(task: Task): Unit = {
    val wait = Random.nextInt(100)
    schedule(task, wait.seconds)
  }
  def retryLater(r: Random, task: Task): Unit = {
    val wait = r.nextInt(100)
    schedule(task, wait.seconds)
  }
}
