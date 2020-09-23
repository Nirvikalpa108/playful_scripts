package example

import java.sql.DriverManager

import anorm._

import scala.util.control.NonFatal

// to run programme in sbt, type "run $age"
// we currently offer the following age parameters (months): 0, 8, 16, 22, 30, 40

object Hello {
  Class.forName("org.sqlite.JDBC")
  implicit val connection = DriverManager.getConnection("jdbc:sqlite:/Users/amina_adewusi/code/adam/childDevelopment.db")
  val parser = Macro.namedParser[Activity]

  def main(args: Array[String]): Unit = {
    // all printlns should live here
    // only place to read args
    // eg reading/writing from terminal
    try {
      // take first parameter (Error)
      val ageInput = args.head
      // ensure parameter is in correct form to be processed (Error)
      val validatedAgeInput = validateAgeInput(ageInput)
      // extractAgeFromInput
      val ageForDbQuery = extractAgeFromInput(validatedAgeInput)
      // get results from db (Error)
      val dbResults = queryAgeDb(ageForDbQuery)
      // format results
      val formattedResults = formatActivities(dbResults)
      // print
      println(formattedResults)
    } catch {
      case NonFatal(error) =>
        println(error.getMessage)
    }
  }

  def validateAgeInput(age: String): Int = {
    age.toInt
  }

  def extractAgeFromInput(ageInput: Int): Int = {
    ageInput match {
      case n if n < 0 => throw new RuntimeException("The minimum age parameter is 0 - please try again!")
      case n if n < 8 => 0
      case n if n < 16 => 8
      case n if n < 22 => 16
      case n if n < 30 => 22
      case n if n < 40 => 30
      case n if n < 60 => 40
      case _ => throw new RuntimeException("The maximum age parameter accepted is 59")
    }
  }

  def queryAgeDb(age: Int): List[Activity] = {
    ???
  }

  def formatActivities(results: List[Activity]): String = {
    ???
  }




  def childDevelopment(ageInput: Int): String = {
    val age = extractAgeFromInput(ageInput)
    val results = SQL"SELECT * FROM earlyYearsFoundationStageFramework WHERE age = ${age}".as(parser.*)
    results.map { activity =>
      s"${activity.id}, ${activity.age}, ${activity.area}, ${activity.subCat}, ${activity.contents}"
    }.mkString("\n")
  }


}

case class Activity(id: Int, age: Int, area: String, subCat: String, contents: String)