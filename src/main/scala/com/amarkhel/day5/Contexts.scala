/*
package com.amarkhel.day5

import scala.concurrent.Future


case class SparkContext[A](name:A)

object Contexts extends App {

  def computation1(i:Int, spark:SparkContext) = {
    i
  }

  def computation2(i:Double, spark:SparkContext) = {
    i
  }

  def computation3(i:String, spark:SparkContext) = {
    i
  }

  val list = List("1", "2", "3")
  val sparkContext = SparkContext("Test")
  for {
    i <- list
    _ = computation1(1, sparkContext)
    _ = computation2(1.0, sparkContext)
    _ = computation3("1", sparkContext)
  } yield i
}

object Contexts2 extends App {

  def computation1(i:Int)(implicit spark:SparkContext) = {
    i
  }

  def computation2(i:Double)(implicit spark:SparkContext) = {
    i
  }

  def computation3(i:String)(implicit spark:SparkContext) = {
    i
  }

  val list = List("1", "2", "3")
  implicit val sparkContext = SparkContext("Test")
  for {
    i <- list
    _ = computation1(1)
    _ = computation2(1.0)
    _ = computation3("1")
  } yield i
}
*/
