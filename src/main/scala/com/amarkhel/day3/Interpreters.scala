/*

package com.amarkhel.day2

object IOIO {

  trait Interpreter {
    def eval(printable:Print)
    def eval(printables:List[Print]) = {
      val summary:Print = printables.reduce(_ combine _)
      eval(summary)
    }
  }

  object ConsoleInterpreter extends Interpreter {
    def eval(value:Print) = {
      println(value.msg)
    }
  }

  object DatabaseInterpreter extends Interpreter {

    val db = ??? //connectToDb()
    def eval(value:Print) = {
      //startTransaction
      db.selectTable("records").save(value.msg)
      //endTransaction
    }
  }

  object InMemoryInterpreter extends Interpreter {

    val logMessages = ??? //create list
    def eval(value:Print) = {
      logMessages.add(value.msg)
    }
    def schedule(interval:Int) = {
      // get all messages accumulated by interval and write to file
    }
  }

  object KafkaInterpreter extends Interpreter {

    val kafka = ??? //create kafka connection
    def eval(value:Print) = {
      kafka.send(value.msg)
    }
  }

  object AsyncInterpreter extends Interpreter {

    val pool = ??? //create executor pool
    def eval(value:Print) = {
      pool.submit(new Runnable(println(value.msg)))
    }
  }

  object GUIInterpreter extends Interpreter {

    val gui = ??? //draw window
    def eval(value:Print) = {
      gui.layout.mainPanel.addText = value.msg
    }
  }
  case class Player(name: String, score: Int)

  case class Print(msg:String){
    def combine(print:Print, oter:Print) = Print(print.msg + oter.msg)
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

*/
