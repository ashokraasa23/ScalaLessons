package lectures.part1basics

/**
  * Created by ashok on 7/15/2018.
  */
object Recusrion extends App{

  def factorial(n:Int): Int ={

    if(n<=1) 1
    else {
      println("Computing factorial of " + n + " I need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Completed Factorial of " + n)
      result
    }
  }

  //println(factorial(5))
  //println(factorial(5000)) // This will throw stackoverflow error

  // To overcome Stackoverflow error use TAIL RECURSION
  def anotherFunction(n:Int):BigInt = {

    def factHelper(x:Int, accumulator:BigInt):BigInt = {

      if (x <= 1) accumulator
      else
        factHelper(x - 1, x * accumulator)
    }

    factHelper(n,1)
  }

  println(anotherFunction(5000))
}
