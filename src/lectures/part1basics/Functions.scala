package lectures.part1basics

/**
  * Created by ashok on 7/14/2018.
  */
object Functions extends App{

  def aFunction(aString: String, n:Int): String = {

    aString + " his age is  " + n
  }

  println(aFunction("Ashok", 29))


  def aRecursiveFunction(aString: String, n:Int):String ={

    if(n==1)aString
    else aString + aRecursiveFunction(aString,n-1)
  }


  println(aRecursiveFunction("Ashok",3))

}
