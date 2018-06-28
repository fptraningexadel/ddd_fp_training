package com.amarkhel.day4.repository.reader

case class Reader[R, A](run: R => A) {
  def map[B](f: A => B): Reader[R, B] =
    Reader(r => f(run(r)))

  def flatMap[B](f: A => Reader[R, B]): Reader[R, B] =
    Reader(r => f(run(r)).run(r))
}
