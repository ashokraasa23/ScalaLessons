package lectures.part2oobasics

/**
  * Created by ashok on 8/4/2018.
  */
object OOBasics extends App {

  val person = new Person("Ashok", 30)

  println(person.age)

  person.greet("Mohan")
  person.greet()

}

//Constructor
class Person(name: String, val age:Int){

  val x =2

  println(1+3)

  //Methods

  def greet(name:String):Unit = println(s"${this.name} says:Hi, $name")

  //Overloading

  def greet(): Unit = println(s"Hi I am $name")

  //Multiple Constructor

  def this(name:String) = this(name,0)

  def this() = this("Saran")
}
