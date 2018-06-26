package com.amarkhel.day2.list

object Example11 {
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = ???
  val xs: List[Int] = List(1,2,3,4,5)
  val ex1 = dropWhile(xs, (x: Int) => x < 4)

  def dropWhile2[A](as: List[A])(f: A => Boolean): List[A] =
    as match {
      case Cons(h,t) if f(h) => dropWhile2(t)(f)
      case _ => as
    }

  /*val xs: List[Int] = List(1,2,3,4,5)
  val ex1 = dropWhile2(xs)(x => x < 4)*/
}
