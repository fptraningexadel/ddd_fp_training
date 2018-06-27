package com.amarkhel.day3

import java.util.concurrent.Executors

import scala.concurrent.{Await, ExecutionContext, Future}

object Algebra {

  sealed trait Expression
  case class Const(value:Int) extends Expression
  case class Add(left:Expression, right:Expression) extends Expression
  case class Mul(left:Expression, right:Expression) extends Expression
  val a = Const(10)
  val b = Add(Const(0), Mul(Const(3), Add(Const(1), Const(2))))
  val program = Add(a, b)
  // 10 + (0 + (3*(1+2)))

  trait Interpreter[A]{
    def eval(expr:Expression):A
  }

  object MathInterpreter extends Interpreter[Int] {
    def eval(expr:Expression):Int = {
      expr match {
        case Const(a) => a
        case Add(b, c) => eval(b) + eval(c)
        case Mul(d, e) => eval(d) * eval(e)
      }
    }
  }

  object PrettyPrintInterpreter extends Interpreter[String] {
    def eval(expr:Expression):String = {
      expr match {
        case Const(a) => a.toString
        case Add(b, c) => s"(${eval(b)} + ${eval(c)})"
        case Mul(d, e) => s"(${eval(d)} * ${eval(e)})"
      }
    }
  }

  object OptimizedInterpreter extends Interpreter[String] {
    def eval(expr:Expression):String = {
      expr match {
        case Const(a) => a.toString
        case Add(Const(0), c) => s"${eval(c)}"
        case Add(c, Const(0)) => s"${eval(c)}"
        case Add(b, c) => s"(${eval(b)} + ${eval(c)})"
        case Mul(d, e) => s"(${eval(d)} * ${eval(e)})"
      }
    }
  }

  object OptimizedInterpreter2 extends Interpreter[String] {
    def eval(expr:Expression):String = {
      expr match {
        case Const(a) => a.toString
        case Add(Const(n), Const(b)) if n == -b => ""
        case Add(b, c) => s"(${eval(b)} + ${eval(c)})"
        case Mul(d, e) => s"(${eval(d)} * ${eval(e)})"
      }
    }
  }

  object AsyncPrintInterpreter extends Interpreter[Future[Int]] {
    implicit val pool = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(5))
    def eval(expr:Expression):Future[Int] = {
      expr match {
        case Const(a) => Future(a)
        case Add(b, c) => {
          for {
            future1 <- eval(b)
            future2 <- eval(c)
          } yield future1 + future2
        }
        case Mul(d, e) => {
          for {
            future1 <- eval(d)
            future2 <- eval(e)
          } yield future1 * future2
        }
      }
    }
  }

  def main(args:Array[String]) = {
    val math = MathInterpreter.eval(program)
    println(math)
    val print = PrettyPrintInterpreter.eval(program)
    println(print)
    val optimized = OptimizedInterpreter.eval(program)
    println(optimized)
    /*println(math)
    println(print)
    println(optimized)
    println("End")*/

    val program2 = Add(Const(3), Add(Const(5), Const(-5)))
    println(OptimizedInterpreter2.eval(program2))

    val async: Future[Int] = AsyncPrintInterpreter.eval(program)
    import scala.concurrent.duration._
    val asyncResult = Await.result(async, Duration.Inf)
    println(s"Result of async invocation is $asyncResult")

  }
}
