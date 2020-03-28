final case class thing(id: Int) //extends AnyVal
object MapValues extends App {
  //https://stackoverflow.com/q/14882642
  val rand = new java.util.Random
  val distribution = Map(thing(0) -> 0.5, thing(1) -> 0.5)
  val perturbed = distribution mapValues {
    _ + 0.1 * rand.nextGaussian
  }
  val sumProbs = perturbed.map { _._2 }.sum
  val newDistribution = perturbed mapValues {
    _ / sumProbs
  }
  println(s"${"-" * 20} mapValues ${"-" * 20}")
  println(s"thing(0): ${newDistribution.get(thing(0))}, thing(1): ${newDistribution.get(thing(1))}")
  println(s"thing(0): ${newDistribution.get(thing(0))}, thing(1): ${newDistribution.get(thing(1))}")

  val distributionView = distribution.view
  val perturbedView = distributionView.mapValues(_ +.1 * rand.nextGaussian)
  val sumProbsOfView = perturbedView.values.sum
  val newDistributionView = perturbedView.mapValues(_ / sumProbsOfView)

  println
  println(s"${"-" * 20} view ${"-" * 20}")

  println(s"thing(0): ${newDistributionView.get(thing(0))}, thing(1): ${newDistributionView.get(thing(1))}")
  println(s"thing(0): ${newDistributionView.get(thing(0))}, thing(1): ${newDistributionView.get(thing(1))}")

  val perturbedMap = distribution.map{case (k, v) => k -> (v +.1 * rand.nextGaussian)}
  val sumProbsOfValues = perturbedMap.values.sum
  val newDistributionMap = perturbedMap.map{ case (k, v) => k -> (v / sumProbsOfValues)}

  println
  println(s"${"-" * 20} Map ${"-" * 20}")

  println(s"thing(0): ${newDistributionMap.get(thing(0))}, thing(1): ${newDistributionMap.get(thing(1))}")
  println(s"thing(0): ${newDistributionMap.get(thing(0))}, thing(1): ${newDistributionMap.get(thing(1))}")

  //  val cache: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map[Int, Int]()
  //
  //  def fibNaive(n: Int): Int = {
  //    require(n > 0)
  //    if (n < 3) 1 else fibNaive(n - 1) + fibNaive(n - 2)
  //  }
  //  def fib(n: Int): Int = {
  //    require(n > 0)
  //    if (n < 3) 1 else cache.getOrElseUpdate(n - 2, fib(n - 2)) + cache.getOrElseUpdate(n - 1, fib(n - 1))
  //  }
  //
  //  def time[T](block: => T): T = {
  //    val start = System.nanoTime()
  //    val res = block
  //    val end = System.nanoTime()
  //    println(s"Took: ${(end - start) * 1E-6} ms, got: $res")
  //    res
  //  }
  //
  ////  time(fibNaive(44))
  //  time(fib(44))
  //  val almostMap = time(cache.mapValues(f => math.log(f) / math.log(.5+math.sqrt(5) / 2)))
  //  time(almostMap(33))
  //  time(almostMap(43))
  //  time(cache(33))
  //  time(cache(43))
}
