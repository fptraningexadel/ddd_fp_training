package com.amarkhel.day2

import scala.util.Try

object HelloScala extends App {
  val d:Unit = println("Hi")
  val list = List(1,2,3)
  val list2 = List(1,2,3)
  val a = for {
    i <- list
    a = println(i)
    j <- list2
  } yield((i, j, a))



  case class Department(name:String)
  case class Employee(name:String, dep:Option[Department])
  def getEmployee(id:Int) = Some(Employee("Andrey", None))

  val a1 = for {
    emp <-getEmployee(1)
    department <- emp.dep
    name = department.name
  } yield println(name)

}
