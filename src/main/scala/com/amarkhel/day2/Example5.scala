package com.amarkhel.day2

object Example5 {
  // A comment!
  /* Another comment */
  /** A documentation comment */
    def abs(n: Int): Int =
      if (n < 0) -n
      else n

    private def formatAbs(x: Int) = {
      val msg = "The absolute value of %d is %d"
      msg.format(x, abs(x))
    }
    def main(args: Array[String]): Unit =
      println(formatAbs(-42))
}
