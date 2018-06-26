package com.amarkhel.day2

import com.amarkhel.day2.model.{Coffee, CreditCard}

object Cafe1 extends App{
  val creditCard = CreditCard()
  Cafe1.buyCoffee(creditCard)
  println(creditCard.amount)

  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee()
    cc.charge(cup.price)
    cup
  }
}