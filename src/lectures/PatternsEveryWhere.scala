package lectures

/**
  * Created by ashok on 9/1/2018.
  */
object PatternsEveryWhere extends App {

  //Big Idea 1

  try{
    //code
  }catch {
    case e : RuntimeException => "Runtime"
    case npe : NullPointerException => "Null exception"
    case _ => "something else"
  }

  //cathes are actually matches, below and above codes are same
  /*
  try{
    //code here
  }catch (e){
    e match {
      case e : RuntimeException => "Runtime"
      case npe : NullPointerException => "Null exception"
      case _ => "something else"
    }
  }
  */

    // Big idea 2
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 ==0
  }yield 10 * x

//Generators are also based on pattern matching
// case classes, :: operators .. are pattern matching
  val tuples = List((1,2),(3,4))
  val filterTuples = for {
    (first,second) <- tuples
  }yield first * second

  // Big idea 3
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)
  //Multiple value definitions based on pattern matching

  val head :: tail = list
  println(head)
  println(tail)

  // Big Idead 4
  //Partial functions are based on pattern matching

  val mappedList = list.map {
    case v if v % 2 ==0 => v + "is even"
    case 1 => "The once"
    case _ => "Something else"
  }

  // below and above codes are same.
  val mappedList2 = list.map (x => x match {
    case v if v % 2 ==0 => v + "is even"
    case 1 => "The once"
    case _ => "Something else"
  })

println(mappedList)
println(mappedList2)
}
