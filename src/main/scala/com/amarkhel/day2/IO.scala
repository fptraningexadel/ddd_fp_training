/*
package com.amarkhel.example

object IO {

}
case class Player(name: String, score: Int)
def contest(p1: Player, p2: Player): Unit =
if (p1.score > p2.score)
Listing 13.1 Program with side effects
230 CHAPTER 13 External effects and I/O
println(s"${p1.name} is the winner!")
else if (p2.score > p1.score)
println(s"${p2.name} is the winner!")
else
println("It's a draw.")

def winnerMsg(p: Option[Player]): String = p map {
case Player(name, _) => s"$name is the winner!"
} getOrElse "It's a draw."
def contest(p1: Player, p2: Player): Unit =
println(winnerMsg(winner(p1, p2)))
trait IO { def run: Unit }
def PrintLine(msg: String): IO = new IO { def run = println(msg) }
def contest(p1: Player, p2: Player): IO = PrintLine(winnerMsg(winner(p1, p2)))*/
