/*
package com.amarkhel.day2

object DSLSample {

  def fahrenheitToCelsius(f: Double): Double = (f - 32) * 5.0/9.0

  def converter: Unit = {
    println("Enter a temperature in degrees Fahrenheit: ")
    val d = readLine.toDouble
    println(fahrenheitToCelsius(d))
  }

  sealed trait Instruction[A]

  case class Read[A](value:() => A) extends Instruction[A]
  case class Print[A](message:A) extends Instruction[A]

  def converter2: Unit = {
    Print("Enter a temperature in degrees Fahrenheit: ")
    val d:Double = Read(() => readLine.toDouble).value()
    Print(fahrenheitToCelsius(d))
  }

  def converter3:Unit = {
    val result = for {
      startMessage <- Print("Enter a temperature in degrees Fahrenheit: ")
      degrees <- Read(() => readLine.toDouble)
      printedMessage <- Print(fahrenheitToCelsius(degrees))
    } yield (printedMessage)
  }
}
*/
