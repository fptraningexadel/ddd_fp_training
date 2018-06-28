package com.amarkhel.day4.repository

import util.Try

trait Repository[A, IdType] {
  def query(id: IdType): Try[Option[A]]
  def store(a: A): Try[A]
}
