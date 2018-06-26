package com.amarkhel.day2

object Example7 extends App{
  def abs(n: Int): Int = if (n < 0) -n else n
  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d."
    msg.format(x, abs(x))
  }
  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }
  override def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }
  formatResult("absolute value", -42, abs) // String = "The absolute value of -42 is 42."
  formatResult("factorial", 7, factorial) // String = "The factorial of 7 is 5040."


}
