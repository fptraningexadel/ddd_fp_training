package com.amarkhel.day2.list

object Example12 {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }
  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x,y) => x + y)
  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)
}
