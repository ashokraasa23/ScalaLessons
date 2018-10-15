package lectures

/**
  * Created by ashok on 8/12/2018.
  */
object WhatsAFunction extends App{

 val doubler= new Function1[Int,Int] {
    override def apply(element:Int):Int = element * 2
  }

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(str:String):Int = str.toInt
  }

  val adder = new Function2[Int,Int,Int] {
    override def apply(a:Int, b:Int):Int = a + b
  }

  val concatentor:((String,String)=> String)  = new Function2[String,String, String] {
    override def apply(a:String, b:String):String = a + b
  }

  //Define a function which takes an Int and resturns another function which takes an Int and returns an Int.

  //Function1[Int,Function1[Int,Int]]

  val supperAdder:Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]] {
    override def apply(x:Int):Function1[Int,Int] = new Function1[Int,Int]{
      override def apply(y:Int):Int = x + y
    }
  }

 // val adder3 = supperAdder(4)
 // println(adder3(-3))
  println(supperAdder(3))
  //println(supperAdder(3)(-4))

  //println(doubler(2))
  //println(stringToIntConverter("5"))
  //println(adder(5,6))
  //println(concatentor("Ashok","Raj"))




}


/*trait MyFunction[A,B]{
  def apply(element:A):B
}*/
