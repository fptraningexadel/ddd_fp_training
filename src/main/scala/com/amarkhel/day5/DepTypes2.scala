package com.amarkhel.day5

object DepTypes2 {

  object Franchise {
    case class Character(name: String, franchise: Franchise)
  }

  class Franchise(name: String) {
    import Franchise.Character
    def createFanFiction(lovestruck: Character, objectOfDesire: Character): (Character, Character) = {
      //require(lovestruck.franchise == objectOfDesire.franchise && this = objectOfDesire.franchise)
      (lovestruck, objectOfDesire)
    }
  }
  class B
  class A {

    var b: Option[B] = None
  }
  val a1 = new A
  val a2 = new A
  val b1 = new B
  val b2 = new B
  a1.b = Some(b1)
  a2.b = Some(b1)
}
