package example
import java.sql.DriverManager
import anorm._
import scala.util.control.NonFatal

// to run programme:
//$ /Users/amina_adewusi/code/adam/childdevelopment/
//$ Sbt
// "run $age"

object Hello {
  Class.forName("org.sqlite.JDBC")
  implicit val connection = DriverManager.getConnection("jdbc:sqlite:/Users/amina_adewusi/code/adam/childDevelopment.db")
  val parser = Macro.namedParser[Activity]

  // all reading/writing from terminal to live in main eg all printlns
  def main(args: Array[String]): Unit = {
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
    SQL"SELECT * FROM earlyYearsFoundationStageFramework WHERE age = ${age}".as(parser.*)
    }

  def formatActivities(results: List[Activity]): String = {
    results.map { activity =>
      s"${activity.id}, ${activity.age}, ${activity.area}, ${activity.subCat}, ${activity.contents}"
    }.mkString("\n")
  }
}

case class Activity(id: Int, age: Int, area: String, subCat: String, contents: String)