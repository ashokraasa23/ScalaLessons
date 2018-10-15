package lectures

/**
  * Created by ashok on 8/12/2018.
  */
object AnonymousFunction extends App {

  val doubler: Int => Int = x=> x * 2

  val doubler1: Int => Int = _ * 2

  val adder = (a:Int,b:Int) => a + b

  val adder1 : (Int, Int) => Int = _+_


  val x = () => 3

  val supperAdder:Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]] {
    override def apply(x:Int):Function1[Int,Int] = new Function1[Int,Int]{
      override def apply(y:Int):Int = x + y
    }
  }

  val supperAdder1  = (x:Int) => (y:Int) => x + y
  val supperAdder2: Int => Int => Int  = x => y => x + y

  println(doubler(2))
  println(doubler1(2))
  println(adder(2,5))
  println(adder1(2,5))
  println(x())

}
