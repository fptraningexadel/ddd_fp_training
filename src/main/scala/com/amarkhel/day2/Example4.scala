/*

package com.amarkhel.example

object Example4 extends App{

  // REFERENTIALLY TRANSPARENT
  val x = "Hello, World" //x: java.lang.String = Hello, World
  val r1 = x.reverse //r1: String = dlroW ,olleH
  val r2 = x.reverse  //r2: String = dlroW ,olleH

  //Suppose we replace all occurrences of the term x with the expression referenced
  // by x(its definition), as follows:
  val r1 = "Hello, World".reverse //r1: String = dlroW ,olleH
  val r2 = "Hello, World".reverse //r2: String = dlroW ,olleH

  // NOT REFERENTIALLY TRANSPARENT

  val x = new StringBuilder("Hello") //x: java.lang.StringBuilder = Hello
  val y = x.append(", World") //y: java.lang.StringBuilder = Hello, World
  val r1 = y.toString  // r1: java.lang.String = Hello, World
  val r2 = y.toString // r2: java.lang.String = Hello, World
  //So far so good

  val x = new StringBuilder("Hello") // x: java.lang.StringBuilder = Hello
  val r1 = x.append(", World").toString // r1: java.lang.String = Hello, World
  val r2 = x.append(", World").toString // r2: java.lang.String = Hello, World, World
}

*/
