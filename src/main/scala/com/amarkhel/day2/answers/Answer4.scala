package com.amarkhel.day2.answers

object Answer4 {
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))
}
