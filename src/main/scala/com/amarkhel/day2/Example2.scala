package com.amarkhel.day2

import com.amarkhel.day2.model.{Charge, Coffee, CreditCard}

object Cafe2 extends App{
  val creditCard = CreditCard()
  val (coffee, charge) = Cafe2.buyCoffee(creditCard)
  println(s"You just bought coffee for ${coffee.price} and you charged by ${charge.amount}")

  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }
}
