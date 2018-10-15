package lectures

/**
  * Created by ashok on 8/15/2018.
  */
object FlatMap extends App {

  val list = List(1,2,3)

  //map
  //println(list.map(_+1))
  //println(list.map(x => x + 1))

  //Filter
  //println(list.filter(_%2==0))
  //println(list.filter(x=> x%2==0))

  //FlatMap
  val topair = (x:Int) => List(x, x+1)
  //println(list.map(topair))
  //println(list.flatMap(topair))

  //Print all combinations between 2 lists

  val numbers = List(1,2,3)
  val chars = List('a' , 'b' , 'c')
  val colors = List("black", "white")

  // O/P -> List("a1", "a2", ...)
  val combinations = numbers.flatMap(n=> chars.map(c=> "" + c + n))

  val combinations1 =

  println(combinations)
}
