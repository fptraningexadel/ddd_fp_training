package com.amarkhel.day5

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

case class LocalResponse(statusCode: Int)
case class RemoteResponse(message: String)

sealed trait Computation {
  type Response
  val work: Future[Response]
}

case class LocalComputation(work: Future[LocalResponse]) extends Computation {
  type Response = LocalResponse
}
case class RemoteComputation(work: Future[RemoteResponse]) extends Computation {
  type Response = RemoteResponse
}

object Service {
  def handle(computation: Computation): computation.Response = {
    val duration = Duration(2, SECONDS)
    Await.result(computation.work, duration)
  }

  def main(args:Array[String]) = {
    val a:LocalResponse = Service.handle(LocalComputation(Future(RemoteResponse(0))))
      a.statusCode
      //.statusCode
    // Result: LocalResponse = LocalResponse(0)
    val a2:RemoteResponse = Service.handle(RemoteComputation(Future(RemoteResponse("remote call"))))
    a2.message
      //.message
    // Result: RemoteResponse = RemoteResponse(remote call)
  }
}


