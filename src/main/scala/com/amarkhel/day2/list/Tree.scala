package com.amarkhel.day2.list
sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
object Tree {
  def size[A](tree:Tree[A]): Int = {
    tree match {
      case Leaf(v) => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }
}
