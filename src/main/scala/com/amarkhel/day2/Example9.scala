package com.amarkhel.day2

object Example9 extends App{
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = ???

  /*def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => ???

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b)*/
}
