package com.amarkhel.day5

import java.io.File

object ImplicitsPath {

  implicit def stringToPath(value : String): PathString = PathString(value)
  implicit def pathToString(value : PathString): String = value.value
  val FILE_SEPARATOR = "/"//File.separator

  case class PathString(value:String){
    //scalastyle:off method.name
    def /(str:String): PathString = {
      val newPath = value.endsWith(FILE_SEPARATOR) match {
        case true => str.startsWith(FILE_SEPARATOR) match {
          case true => value + str.substring(1)
          case false => value + str
        }
        case false => str.startsWith(FILE_SEPARATOR) match {
          case true => value + str
          case false => value + FILE_SEPARATOR + str
        }
      }
      copy(newPath)
    }
    def ! : String = if(value.endsWith(FILE_SEPARATOR)) value else value + FILE_SEPARATOR
    def ? : String = value
    //scalastyle:on method.name
  }


}
