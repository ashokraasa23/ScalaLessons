package lectures

/**
  * Created by ashok on 9/1/2018.
  */
object AllPatterns extends App {

  //1. Constants
  val x:Any = "Scala"
  val constants = x match {
    case 1 => "a Number"
    case "Scala"  => "The Scala"
    case true => "The Truth"
    case AllPatterns => "A Singleton Object"
  }

  //2. Match anything
  //2.1 wildcard
  val matchAnything = x match {
    case _ => "Anything can be matched with this"
  }

  //2.2 Variable
  val matchVariable = x match {
    case something => s"we can use $something like this"
  }

  //3. Tuples
  val aTuple = (1,2)
  val aMatchTuple = aTuple match {
      case(1,1) =>
      case(something, 2) => s"we can use $something like this"
  }

  val nestedTuple = (1,(2,3))
  val matchNestedTuple = nestedTuple match {
    case(_,(2,v)) =>
  }

  //4.List patterns
  val aStandardList = List(1,2,3,42)
  val aStandardListMatch = aStandardList match {
    case List(1,_,_,_) => //Extractor
    case List(1,_*) => //List of arbitary length
    case l :: List(_) => //Infix pattern
    case List(1,2,3) :+ 42 => //Infix pattenn
  }

  //5.Type Specifiers
  val unknow:Any = 2
  val unknownmatch = unknow match {
    case v:Int => //Explicit type sepcifires, so the pattern with exact type will goes through.
  }

 //6. Name Binding
  val nameBindingMatch = unknow match {
    case ashok @ 2 => // So here we assign the pattern with name, so we can use anywhere we need.
      // case Cons(1, rest @ Cons(2,_)) => // we can specify names at nested patterns
  }

  //7. Multi-Patterns
  val multipatterns = unknow match {
    case 2 | 1 => //So here we can use or, and to combine multiple patterns
  }

  //9 - If guards
  val ifGuards = unknow match {
    case 3 if 3 % 2 ==0 =>
  }


}
