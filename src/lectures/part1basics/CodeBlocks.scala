package lectures.part1basics

/**
  * Created by ashok on 7/14/2018.
  */
object CodeBlocks extends App{

  val i =5

  val s = if(i==5) "greater than 5" else "less than 5"

  println(s)

  val someValue = {
    2<3
  }

  val someotherValue  ={
    if(someValue) 239 else 986
  }

  print(someotherValue)
}
