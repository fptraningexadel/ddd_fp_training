/*

package com.amarkhel.example

import com.amarkhel.example.IO4.Print

case class Player(name: String, score: Int)

object IO {
  def contest(p1: Player, p2: Player): Unit = {
    if (p1.score > p2.score)
      println(s"${p1.name} is the winner!")
    else if (p2.score > p1.score)
      println(s"${p2.name} is the winner!")
    else println("It's a draw.")
  }
}

object IO2 {

  def getWinner(p1: Player, p2: Player) : Option[Player] = {
    if (p1.score > p2.score) Some(p1)
    else if (p2.score > p1.score) Some(p2)
    else None
  }
  def contest(p1: Player, p2: Player): Unit = {
    val winner = getWinner(p1, p2)
    val winnerMessage = winner match {
      case Some(x) => s"${x.name} is the winner"
      case None => "It's a draw"
    }
    println(winnerMessage)
  }
}

object IO3 {

  def getWinner(p1: Player, p2: Player) : Option[Player] = {
    if (p1.score > p2.score) Some(p1)
    else if (p2.score > p1.score) Some(p2)
    else None
  }

  def getWinnerMessage(winner:Option[Player]) = {
    winner match {
      case Some(x) => s"${x.name} is the winner"
      case None => "It's a draw"
    }
  }

  def contest(p1: Player, p2: Player): Unit = {
    println(getWinnerMessage(getWinner(p1, p2)))
  }
}

object IO4 {

  case class Print(msg:String)

  def combine(m1:Print, m2:Print)= {
    Print(m1.msg + m2.msg)
  }

  def getWinner(p1: Player, p2: Player) : Option[Player] = {
    if (p1.score > p2.score) Some(p1)
    else if (p2.score > p1.score) Some(p2)
    else None
  }

  def getWinnerMessage(winner:Option[Player]) = {
    winner match {
      case Some(x) => s"${x.name} is the winner"
      case None => "It's a draw"
    }
  }

  def contest(p1: Player, p2: Player): Print = {
    Print(getWinnerMessage(getWinner(p1, p2)))
  }
}

object IO5 {
  val p1 = Player("Andrey", 100)
  val p2 = Player("Oleg", 25)
  val programDescription:Print = IO4.contest(p1, p2)

}

trait Interpreter {
  def eval(value:Print)
}

object ConsoleInterpreter extends Interpreter {
  def eval(value:Print) = {
    println(value.msg)
  }
}

object DatabaseInterpreter extends Interpreter {

  val db = ??? //connectToDb()
  def eval(value:Print) = {
    //start transcation
    db.selectTable("records").save(value)
    //end transaction
  }
}

object GUIInterpreter extends Interpreter {

  val gui = ??? //draw window
  def eval(value:Print) = {
    gui.layout.mainPanel.addText = value
  }
}

def main(args:Array[String]) = {
  val listGames = List(games..)
  val onePrint = listGames.reduce(combine)
  eval(onePrint)
}
/*def winnerMsg(p: Option[Player]): String = p map {
case Player(name, _) => s"$name is the winner!"
} getOrElse "It's a draw."
def contest(p1: Player, p2: Player): Unit =
println(winnerMsg(winner(p1, p2)))
trait IO { def run: Unit }
def PrintLine(msg: String): IO = new IO { def run = println(msg) }
def contest(p1: Player, p2: Player): IO = PrintLine(winnerMsg(winner(p1, p2)))*/

*/
