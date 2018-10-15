package exercise

/**
  * Created by ashok on 7/14/2018.
  */
object FunctionExercise extends App {

  def greetFunction(name: String, age: Int): String = {

    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  //println(greetFunction("Ashok", 30))

  def aFactorialFunction(n:Int): Int = {

    if(n <=0) 1
    else n * aFactorialFunction(n-1)
  }

 // print(aFactorialFunction(5))

  def aFibbonasiFunction(n:Int):Int ={

    if (n<=2) 1
    else aFibbonasiFunction(n-1) + aFibbonasiFunction(n-2)
  }
  //println(aFibbonasiFunction(8))

  def aPrime(n:Int): Boolean = {

    def aPrimeUntil(t:Int):Boolean =
      if(t<=1) true
      else (n%t !=0) && aPrimeUntil(t-1)

    aPrimeUntil(n/2)
  }

  println(aPrime(11))
}

