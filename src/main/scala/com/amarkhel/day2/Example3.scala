package com.amarkhel.day2

import com.amarkhel.day2.model.{Charge, Coffee, CreditCard}

import scala.collection.immutable.List

object Cafe3 extends App {

  /*val (_, charge) = Cafe3.buyCoffees(CreditCard(), 5)
  println(s"You just bought 5 cups of coffees and you charged by ${charge.amount}")*/

  def buyCoffee(cc: CreditCard): (Coffee, Charge) = ???

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1,c2) => c1.combine(c2)))
  }

  def eval(i:Int)(func:Int => Int) = {
    func(i)
  }

  def eval3 = eval(3) _

  def square(i:Int) = i*i

  def increment(i:Int):Int = i + 1

  println(eval3(square))
  println(eval3(increment))

  def coalesce(charges: List[Charge]): List[Charge] = charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
  /*
  This function takes a list of charges,
groups them by the credit card used, and then combines them into a single charge
per card. It’s perfectly reusable and testable without any additional mock objects or
interfaces. Imagine trying to implement the same logic with our first implementation
of buyCoffee!

   */
}
