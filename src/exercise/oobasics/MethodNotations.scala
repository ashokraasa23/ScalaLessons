package exercise.oobasics

/**
  * Created by ashok on 8/5/2018.
  */
object MethodNotations extends App{

  class Person(val name: String, val favouriteMovie:String, val age:Int = 0){

    def likes(movie:String): Boolean = movie == favouriteMovie
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name} and watching ${this.favouriteMovie}"
    def +(nickname: String):Person = new Person(s"$name ($nickname)", favouriteMovie)
    def unary_! : String = s"$name, what the heck!"
    def unary_+ : Person = new Person(name, favouriteMovie, age+1)
    def learns(sub:String) = s"$name learns $sub"
    def learnsScala = mary.learns("Scala")
    def isAlive : Boolean = true
    def apply() : String = "This is apply method"
    def apply(n:Int) : String = s"${mary.name} watched ${mary.favouriteMovie} $n times"
  }


  val mary = new Person("Ashok", "Inception",0)
  println(mary(2))
 // println(mary learnsScala)
   // println((+mary).age)
 // println(mary likes "Inception")
 // println(!mary)
 // println(mary isAlive)
 // println(mary())

  val tom = new Person("Tom" , "Fight Club")
  //println(tom + (mary + "Raasa"))
  //println (mary + tom )


}
