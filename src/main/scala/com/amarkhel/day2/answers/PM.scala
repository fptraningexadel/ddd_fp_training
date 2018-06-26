package com.amarkhel.day2.answers

import com.amarkhel.day2.list.{Cons, List, Nil}

object PM extends App {
  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) =>x+y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
  }
  println(x)

  def drop[A](l: List[A], n: Int): List[A] = {

    def loop(current:Int, list:List[A]) : List[A] = {
      if(current == 0) list
      else list match {
        case Nil => Nil
        case Cons(h, t) => loop(current - 1, list)
      }
    }

    loop(n, l)
  }

}
