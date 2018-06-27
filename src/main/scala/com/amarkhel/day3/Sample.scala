package com.amarkhel.day3

object Sample {

  case class Player(score:Int, name:String)

  def contest(p1: Player, p2: Player): Unit = {
    if (p1.score > p2.score)
      println(s"${p1.name} is the winner!")
    else if (p2.score > p1.score)
      println(s"${p2.name} is the winner!")
    else println("It's a draw.")
  }

  def getWinner(p1:Player, p2:Player):Option[Player] = {
    if(p1.score > p2.score) Some(p1)
    else if(p1.score < p2.score) Some(p2)
    else None
  }

  def contest2(p1: Player, p2: Player) = {
    getWinner(p1, p2) match {
      case Some(Player(name, _)) => println(s"The winner is $name")
      case None=> println("It is a draw")
    }
  }

  def getWinnerMessage(p:Option[Player]) = {
    p match {
      case Some(Player(name, _)) => s"The winner is $name"
      case None=> "It is a draw"
    }
  }

  def contest3(p1: Player, p2: Player) = {
    println(getWinnerMessage(getWinner(p1, p2)))
  }

  def contest4(p1: Player, p2: Player) = {
    Print(getWinnerMessage(getWinner(p1, p2)))
  }

  case class Print(msg:String)
}
