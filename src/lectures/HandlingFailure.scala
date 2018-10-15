package lectures

import scala.util.{Failure, Random, Success, Try}

/**
  * Created by ashok on 9/1/2018.
  */
object HandlingFailure extends App {

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess)
  println(aFailure)

  def unSafeMethod(): String = throw new RuntimeException("No String for you")

  val  potentialFailure = Try(unSafeMethod())
  println(potentialFailure)

  //Syntactic Sugar in practice

  val anotherPotentinalFailue = Try {
    //Code that throw exceptions
  }

  //Utilities
  println(potentialFailure.isSuccess)

  //OrElse

  def betterUnSafeMethod: Try[String] = Failure(new RuntimeException)
  def betterBackUpMethod: Try[String] = Success("A valid result")

  val betterFallBack = betterUnSafeMethod orElse betterBackUpMethod
  println(betterFallBack)

  //map,FaltMap, Filter

  println(aSuccess.map(_*10))
  println(aSuccess.flatMap(x=> Success(x * 10)))
  println(aSuccess.filter(_>10))

  /*
  Excerise
   */

  val host = "localHost"
  val port = "8080"
  def renderHTML(page:String) = println(page)

  class Connection{
    def get(url:String):String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>..</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url:String):Try[String] = Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())

    def getConnection(host:String, port:String):Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host:String, port:String): Try[Connection] = Try(getConnection(host,port))
  }

  //If you get the html page from the connection, print it to the console i.e call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host,port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //Shorehand Version
  HttpService.getSafeConnection(host,port)
      .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  //For-Comprehension Verison
  for{
    connection <- HttpService.getSafeConnection(host,port)
    html <- connection.getSafe("/home")
  }renderHTML(html)

  /*In Imperative langugae

  try{
    connection = HttpService.getSafeConnection(host,port)
    try{
    connection.getSafe("/home")
    renderHTML(page)
    }
    catch(Exception){
    }
  }
  catch(Exception){
  }

  */

}
