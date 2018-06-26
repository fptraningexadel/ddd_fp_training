package com.amarkhel.day2

object Example6 extends App{
  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }

  println(factorial(12))
}
