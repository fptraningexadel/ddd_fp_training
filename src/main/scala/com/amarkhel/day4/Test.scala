package com.amarkhel.day4

import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

object Test extends App {

  case class Account()

  /*val propReverseList = forAll { l: List[String] => l.reverse.reverse == l }

  val propConcatString = forAll { (s1: String, s2: String) =>
    (s1 + s2).endsWith(s2)
  }
  val intList = Gen.listOf(Gen.choose(0,100))
  val prop =
    forAll(intList)(ns => ns.reverse.reverse == ns) &&
      forAll(intList)(ns => ns.headOption == ns.reverse.lastOption)*/
  val propSum = forAll { l: List[String] => l.contains(l.max) }
/*  propReverseList.check
  propConcatString.check*/
  propSum.check
}
