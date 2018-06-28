package com.amarkhel.day3

case class Employee(name:String, manager:Option[Employee], department:Option[Department])
case class Department(name:String)

object MyOption{

  def getEmployee(i:Int) = {
      if(i > 1) Some(Employee("Andrey", Some(Employee("Lena", None, Some(Department("HR")))), Some(Department("Development"))))
      else None
  }

  val a: Option[Employee] = getEmployee(2)
  val b: Option[Employee] = if(a.isDefined) a.get.manager else None
  val c: Option[Department] = if(b.isDefined) b.get.department else None
  val d: Option[String] = if(c.isDefined) Some(c.get.name) else None
  val e:String = d.getOrElse("Not Exist")
  println(d)

  val name = getEmployee(2).flatMap(e => e.manager.flatMap(m => m.department.flatMap( d => d.name) ))

  val name = (for {
    a <- getEmployee(2)
    b <- a.manager
    c <- b.department
    d = c.name
  } yield d).getOrElse("NotExist")

}
