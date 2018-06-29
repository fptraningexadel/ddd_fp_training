
package com.amarkhel.day5

import java.io.InputStream

trait FileLikeT[T] {
  def name(file : T) : String
  def isDirectory(file : T) : Boolean
  def children(directory : T) : Seq[T]
  def child(parent : T, name : String) : T
  def mkdirs(file : T) : Unit
  def content(file : T) : InputStream
  def writeContent(file : T, otherContent : InputStream) : Unit



}

object Git {
  def synchronize[F : FileLikeT, T : FileLikeT](from : F, to : T) : Unit = {
    val fromHelper = implicitly[FileLikeT[F]]
    val toHelper = implicitly[FileLikeT[T]]

    def synchronizeFile(file1 : F, file2 : T) : Unit = {
      toHelper.writeContent(file2, fromHelper.content(file1))
    }

    def synchronizeDirectory(dir1 : F, dir2 : T) : Unit = {
      def findFile(file : F, directory : T) : Option[T] =
        (for {
          file2 <- toHelper.children(directory)
          if fromHelper.name(file) == toHelper.name(file2)
        } yield file2).headOption

      for(file1 <- fromHelper.children(dir1)) {
        val file2 = findFile(file1, dir2).getOrElse(toHelper.child(dir2, fromHelper.name(file1)))
        if(fromHelper.isDirectory(file1)) {
          toHelper.mkdirs(file2)
        }
        synchronize[T,F](file1, file2)
        //synchronize[F,T](file2, file1)
      }
    }

    if(fromHelper.isDirectory(from)) {
      synchronizeDirectory(from,to)
    } else {
      synchronizeFile(from,to)
    }
  }

  synchronize(new java.io.File("tmp1"), new java.io.File("tmp2"))
}

/*
import java.io.File
object FileLikeT {
  implicit val ioFileLike = new FileLikeT[File] {
    override def name(file: File) = file.getName()
    override def isDirectory(file: File) = file.isDirectory()
    override def children(directory: File) = directory.listFiles()
    override def child(parent: File, name: String) = new java.io.File(parent, name)
    override def mkdirs(file: File) : Unit = file.mkdirs()
    override def content(file: File) = ???
    override def writeContent(file: File, otherContent: InputStream) = ???
  }
}*/

