package example

import java.sql.DriverManager

import anorm._

object Hello {
  Class.forName("org.sqlite.JDBC")
  implicit val connection = DriverManager.getConnection("jdbc:sqlite:/Users/amina_adewusi/code/adam/childDevelopment.db")
  val parser = Macro.namedParser[Activity]

  def main(args: Array[String]): Unit = {
    val age = args.head.toInt
    val results = SQL"SELECT * FROM earlyYearsFoundationStageFramework WHERE age = ${age}".as(parser.*)
    val formattedResults = results.map { activity =>
        s"${activity.id}, ${activity.age}, ${activity.area}, ${activity.subCat}, ${activity.contents}"
    }
    println(formattedResults.mkString("\n"))
  }
}

case class Activity(id: Int, age: Int, area: String, subCat: String, contents: String)


// list all rows in db