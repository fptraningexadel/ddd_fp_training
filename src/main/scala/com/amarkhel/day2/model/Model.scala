package com.amarkhel.day2.model

case class CreditCard(amount:Double = 0.0){
  def charge(price:Double) = copy(amount = amount - price)
}

case class Coffee(price:Double = 1.0)

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}


