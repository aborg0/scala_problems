object MonadsDoNotCompose extends App {
  println(for {i <- Seq(0, 1, 42)
               str <- Option("")
               } yield (str, i))
//  println(for {str <- Option("")
//               i <- Seq(0, 1, 42)
//               } yield (str, i))


































    println(for {str <- Option("").to(Seq)
                 i <- Seq(0, 1, 42)
                 } yield (str, i))


}
