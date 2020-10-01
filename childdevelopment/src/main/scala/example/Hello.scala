package example
import java.sql.DriverManager
import anorm._
import scala.util.control.NonFatal

// to run programme:
//$ cd /Users/amina_adewusi/code/adam/childdevelopment/
//$ Sbt
// "run $age"

object Hello {
  Class.forName("org.sqlite.JDBC")
  implicit val connection = DriverManager.getConnection("jdbc:sqlite:/Users/amina_adewusi/code/adam/childDevelopment.db")
  val parser = Macro.namedParser[Activity]

  def main(args: Array[String]): Unit = {
    try {
      val ageInput = args.head
      val areaInput = args(1)
      val validatedAgeInput = validateAgeInput(ageInput)
      val ageForDbQuery = extractAgeFromInput(validatedAgeInput)
      val areaForDbQuery = extractAreaFromInput(areaInput)
      val dbResults = queryAgeDb(ageForDbQuery, areaForDbQuery)
      val formattedResults = formatActivities(dbResults)
      println(formattedResults)
    } catch {
      case NonFatal(error) =>
        println(error.getMessage)
    }
  }

  def validateAgeInput(age: String): Int = age.toInt

  def extractAgeFromInput(ageInput: Int): Int = {
    ageInput match {
      case n if n < 0 => throw new RuntimeException(
        "The minimum age parameter is 0 - please try again!")
      case n if n < 8 => 0
      case n if n < 16 => 8
      case n if n < 22 => 16
      case n if n < 30 => 22
      case n if n < 40 => 30
      case n if n < 60 => 40
      case _ => throw new RuntimeException(
        "The maximum age parameter accepted is 59")
    }
  }
  
  def extractAreaFromInput(area: String): String = {
    area match {
      case "PSE" => "PSE"
      case "PE" => "Physical Development"
      case "Feelings" => "Managing feelings and behaviour"
      case "Communication" => "Communication and Language"
      case "Literacy" => "Literacy"
      case "Maths" => "Mathematics"
      case "World" => "Understanding the World"
      case "Arts" => "Expressive Arts and Design"
    }
  }

  def queryAgeDb(age: Int, area: String): List[Activity] = {
    SQL"SELECT * FROM earlyYearsFoundationStageFramework WHERE age = ${age} AND area = ${area}"
      .as(parser.*)
    }

  def formatActivities(results: List[Activity]): String = {
    results.map { activity =>
      s"${activity.id}, ${activity.age}, ${activity.area}, ${activity.subCat}, ${activity.contents}"
    }.mkString("\n")
  }
}

case class Activity(id: Int, age: Int, area: String, subCat: String, contents: String)