package com.amarkhel.day5

object Display {

  trait Displayable[A]

  object Screen {
    def printOnScreen[A:Displayable](value:A): Unit = {
       println(value)
    }
    def printOnScreen2[A](value:A): Unit = {
      println(value)
    }
  }
  def main(args:Array[String]) = {
    val d = 1.0
    implicit val doubleDisplayable = new Displayable[Double]()
    Screen.printOnScreen2(d)
    Screen.printOnScreen(d)

    /*Screen.printOnScreen2(d)
    Screen.printOnScreen(d)*/
  }


}
