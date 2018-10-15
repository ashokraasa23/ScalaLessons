package exercise

/**
  * Created by ashok on 7/15/2018.
  */
object Recursive extends App {


  def greetFunction(name:String, n:Int, accumulator:String): String = {

    if(n<=0) accumulator
    else greetFunction(name,n-1,name + accumulator)

  }

  //println(greetFunction("Ashok", 3, " "))


  def isprime(num:Int): Boolean ={

    def isprimeHelp(n:Int, accumlator: Boolean):Boolean =

      if(!accumlator) false
      else if(n<=1) accumlator
      else(isprimeHelp(n-1,num%n!=0 && accumlator))

    isprimeHelp(num/2,true)
  }
  println(isprime(6))
}
