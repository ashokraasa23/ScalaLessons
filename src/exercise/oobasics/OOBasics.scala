package exercise.oobasics

/**
  * Created by ashok on 8/4/2018.
  */
object OOBasics extends App{

  val writer = new Writer("Ashok", "Raj", 1987)
  val novel = new Novel("book1", 2008, writer)
  val age = novel.authorAge
  val aname = novel.isWrittenBy
  val lstNovelrelase = novel.copy(2018).yrOfRls

  println(s"The author age is $age")
  println(s"The author name is $aname")
  println(s"The latest Novel is $lstNovelrelase")

}

class Writer(firstName: String, surName:String, val yearOfBirth:Int){

  def fullName():String = firstName + " " + surName

}

class Novel(name:String, val yrOfRls: Int, author: Writer){

  def authorAge()  = 2018 - author.yearOfBirth

  def isWrittenBy() = author.fullName()

  def copy(year:Int) = new Novel(name,year,author)



}
