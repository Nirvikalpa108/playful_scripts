package example

import example.Hello.{extractAgeFromInput, extractAreaFromInput, formatActivities, validateAgeInput}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloTest extends AnyFreeSpec with Matchers {
  "validateAgeInput" - {
    "returns 0 if given the String 0" in {
      validateAgeInput("0") shouldEqual 0
    }
    "throws an exception if given a String that cannot be turned into an Int" in {
      an[Exception] should be thrownBy validateAgeInput("a")
    }
  }

  "extractAgeFromInput" - {
    "returns 0 for an input of 7" in {
      extractAgeFromInput(7) shouldEqual 0
    }
    "returns an error for an input of 60" in {
      a[RuntimeException] should be thrownBy extractAgeFromInput(60)
    }
    "returns an error for a negative input" in {
      a[RuntimeException] should be thrownBy(extractAgeFromInput(-1))
    }
  }

  "extractAreaFromInput" - {
    "returns PSE for an input of PSE" in {
      extractAreaFromInput("PSE") shouldEqual "PSE"
    }
    "returns Communication and Language for an input of Communication" in {
      extractAreaFromInput("Communication") shouldEqual "Communication and Language"
    }
    "returns Expressive Arts and Design for an input of Arts" in {
      extractAreaFromInput("Arts") shouldEqual "Expressive Arts and Design"
    }
  }

  "formatActivities" - {
    "returns string when given List of Activities" in {
      val input: List[Activity] = List(Activity(23, 59, "test", "test", "test"))
      val result: String = "23, 59, test, test, test"
      formatActivities(input) shouldEqual result
    }
  }
}
