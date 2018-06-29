package com.amarkhel.day5

trait GameRepo
object MongoGameRepo extends GameRepo
case class Game(name:String){
  lazy val stats = new GameStatistics
}
class GameStatistics {
   val repo:GameRepo = MongoGameRepo
//heavy computation using repo
  val g =new Game("a")

  def f(a:Int => Double)

  def d(func : => Double) = {
    func()
  }

  val func1 = => 1.0

  val func2 = (i:Int) => 2.0()

  def d1(d:Double) = {

  }

}

object Lazy {

}
