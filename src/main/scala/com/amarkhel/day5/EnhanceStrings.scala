package com.amarkhel.day5

object EnhanceStrings extends App{


  implicit class StringImprovements(s: String) {
    def startsWith(prefix:String):Boolean = true
  }

  //StringUtils.increment(str)
  println("HAL".startsWith("B"))
}
