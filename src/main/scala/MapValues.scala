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
  println(s"${"\u2500" * 20} mapValues ${"\u2500" * 40}")
  println(s"thing(0): ${newDistribution.get(thing(0))}, thing(1): ${newDistribution.get(thing(1))}")
  println(s"thing(0): ${newDistribution.get(thing(0))}, thing(1): ${newDistribution.get(thing(1))}")

  val distributionView = distribution.view
  val perturbedView = distributionView.mapValues(_ +.1 * rand.nextGaussian)
  val sumProbsOfView = perturbedView.values.sum
  val newDistributionView = perturbedView.mapValues(_ / sumProbsOfView)

  println
  println(s"${"\u2500" * 20} view ${"\u2500" * 45}")

  println(s"thing(0): ${newDistributionView.get(thing(0))}, thing(1): ${newDistributionView.get(thing(1))}")
  println(s"thing(0): ${newDistributionView.get(thing(0))}, thing(1): ${newDistributionView.get(thing(1))}")

  val perturbedMap = distribution.map{case (k, v) => k -> (v +.1 * rand.nextGaussian)}
  val sumProbsOfValues = perturbedMap.values.sum
  val newDistributionMap = perturbedMap.map{ case (k, v) => k -> (v / sumProbsOfValues)}

  println
  println(s"${"\u2500" * 20} Map ${"\u2500" * 46}")

  println(s"thing(0): ${newDistributionMap.get(thing(0))}, thing(1): ${newDistributionMap.get(thing(1))}")
  println(s"thing(0): ${newDistributionMap.get(thing(0))}, thing(1): ${newDistributionMap.get(thing(1))}")
}
