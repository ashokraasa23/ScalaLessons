package lectures

/**
  * Created by ashok on 8/14/2018.
  */
object HOFandCurries extends App{

  // Function that applies a function n times over a value x

  // ntimes(f,n,x) = f(f(...f(x))) = ntimes(f,n-1.f(x))

  def ntimes(f:Int => Int, n:Int, x:Int):Int =

    if(x<=0) x
    else ntimes(f,n-1,f(x))


  val plusOne = (x:Int) => x + 1

  //println(ntimes(plusOne,10,1))


  //ntimesBetter(f,n) = x => f(f(f(...f(x))

  def nTimesBetter(f:Int => Int, n:Int):Int => Int =

    if(n<=0) (x:Int) => x
    else (x:Int) => nTimesBetter(f,n-1)(f(x))

  val plus10 = nTimesBetter(plusOne,10)

  //println(plus10(1))

  // Functions with multiple parameter list

  def curriedFunctions(c:String)(x:Double): String = c.format(x)

  //println(curriedFunctions("%4.2f"))
  val standardFormat : (Double => String) = curriedFunctions("%4.2f")
  val preciseFormat : (Double => String) = curriedFunctions("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
