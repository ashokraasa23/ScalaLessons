package lectures

import scala.util.Random

/**
  * Created by ashok on 9/1/2018.
  */
object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val desc = x match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "SomeThing else"
  }
  println(x)
  println(desc)

  //1. Decompose case class values

  case class Person(name:String, age:Int)
  val bob = Person("bob", 21)

  val greeting = bob match {
    case Person(n,a) if a < 21 => s"$n with age as $a will not able to drink in US"
    case Person(n,a) => s"$n and age is $a"
    case _ => "I don't know my Name"
  }
  println(greeting)

  //PM on selead classed

  sealed class Animal
  case class Dog(breed:String) extends Animal
  case class Cat(greet:String) extends Animal

  val animal:Animal = Dog("nattu")

  animal match {
    case Dog(someBreed) => println(s"Matched dog is $someBreed")
  }
  /*
  1. cases are matched in order
  2. What if we didn't provide case _ and no matches found? MatchError exception
  3. What is return type of PM? if all cases returns same type then it is the type of PM. else Any is the type
  4. Pattern matching works really well in case class. becasue case class has extracted pattern out of the box.
  5. If you are using PM in sealed hirerarchy then we need to cover all cases else compiler will throw error.
   */

  /*
  Exercise
   */

  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr, e2:Expr) extends Expr
  case class Prod(e1:Expr, e2:Expr) extends Expr

  def show(e:Expr):String = e match {

    case Number(n) => s"$n"
    case Sum(e1,e2) => show(e1) + " + " + show(e2)
    case Prod(e1,e2) => {
      def mayBeShowParenthesis(exp: Expr) = exp match {
        case Prod(_,_) => show(exp)
       case Number(_) => show(exp)
      case _ => "(" + show(exp) + ")"
      }
     mayBeShowParenthesis(e1) + " * " + mayBeShowParenthesis(e2)
   }
 }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))

}