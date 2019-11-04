object Inaccessible extends App {
  { // Scala Doubles
    val nan = Double.NaN
    val map = collection.immutable.HashMap(nan -> 4d, 4d -> 3d)
    val jMap = new java.util.HashMap[Double, Double]()

    {
      jMap.put(nan, 4d)
      jMap.put(4d, 3d)
    }
    println(s"Scala Map, Scala Double.NaN: ${map.get(Double.NaN)}")
    println(s"Scala Map, Scala nan: ${map.get(nan)}")
    println(s"Java Map, Scala Double.NaN: ${jMap.get(Double.NaN)}")
    println(s"Java Map, Scala nan: ${jMap.get(nan)}")
  }
  println

  { // Java Doubles
    val nan = java.lang.Double.NaN
    val map = collection.immutable.HashMap(nan -> 4d, 4d -> 3d)
    val jMap = new java.util.HashMap[java.lang.Double, java.lang.Double]()

    {
      jMap.put(nan, 4d)
      jMap.put(4d, 3d)
    }
    println(s"Scala Map, Java Double.NaN: ${map.get(java.lang.Double.NaN)}")
    println(s"Scala Map, Java nan: ${map.get(nan)}")
    println(s"Java Map, Java Double.NaN: ${jMap.get(java.lang.Double.NaN)}")
    println(s"Java Map, Java nan: ${jMap.get(nan)}")

    println(s"Java Map, 0d/0d (${java.lang.Long.toHexString(java.lang.Double.doubleToRawLongBits(0d/0d))}): ${
      jMap.get(0d/0d)}")
    println(s"Java Map, other NaN (${java.lang.Long.toHexString(0xfff8000000000001L)}): ${
      jMap.get(java.lang.Double.longBitsToDouble(0xfff8000000000001L))}")
    println(s"Java Map, other NaN (${java.lang.Long.toHexString(0xfff7ffffffffffffL)}): ${
      jMap.get(java.lang.Double.longBitsToDouble(0xfff7ffffffffffffL))}")
  }
}
