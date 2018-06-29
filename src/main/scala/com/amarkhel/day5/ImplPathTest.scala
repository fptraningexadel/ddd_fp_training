package com.amarkhel.day5

import ImplicitsPath._

object ImplPathTest extends App{

  val pathLong = "filesystem" + FILE_SEPARATOR +  "folder/"  +  FILE_SEPARATOR + "folder2" + FILE_SEPARATOR
  val path = "filesystem" / "folder/" / "folder2"!

  println(pathLong)
  println(path)
}
