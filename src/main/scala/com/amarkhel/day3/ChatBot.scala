package com.amarkhel.day3

import java.time.LocalDateTime

object ChatBot {

  case class User(name:String, age:Int, address:Address)
  case class Address(city:String, street:String, building:Int)

  sealed trait Message
  case class ChatMessage(msg:String, time:LocalDateTime, user:User) extends Message
  case class UserJoined(time:LocalDateTime, user:User) extends Message
  case class UserLeaved(time:LocalDateTime, user:User) extends Message
  case class SystemMessage(msg:String, time:LocalDateTime) extends Message

  val stopWords = List("Damn")
  def run(messages:List[Message]) = {
    messages.foreach(handleMessage)
    //val a:Any = //....
  }

  private def handleMessage(message: Message) = {
    message match {
      case ChatMessage(msg, _, _) if(stopWords.filter(msg.contains)).length > 0 => println(s"Your message is censored")
      case ChatMessage(msg, _, User("admin", _, _)) => println(s"Message from admin: $msg")
      case ChatMessage(msg, _, User(name, age, Address(city, streey, building))) => println(s"$name just said $msg")
      case UserJoined(time, User(name, _, Address(_, _, _))) => println(s"$name joined at $time")
      case UserLeaved(_, User(name, _, Address(_, _, _))) => println(s"unfortunately $name leaved the room")
      case SystemMessage(msg, time) => println(s"$time IMPORTANT! $msg")
    }
  }

  def main(args:Array[String]) = {
    val user = User("user", 18, Address("Minsk", "Street", 18))
    val admin = User("admin", 25, Address("Vilnius", "Street", 18))
    val messages = List(
      ChatMessage("Damn, I tired...", LocalDateTime.now(), user),
      ChatMessage("Hello all!", LocalDateTime.now(), admin),
      ChatMessage("Hello all!", LocalDateTime.now(), user),
      UserJoined(LocalDateTime.now, user),
      UserLeaved(LocalDateTime.now, user),
      SystemMessage("Conversation ended", LocalDateTime.now)
    )
    messages.foreach(handleMessage)
  }
}
