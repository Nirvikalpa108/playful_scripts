package example

import example.Hello.{extractAgeFromInput, validateAgeInput}
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

  // dont write a test to queryAgeDb
  // write one for format
  // then implement the functions

  "errorForIncorrectAgeParameterInput" - {
    // receive the incorrect user input
    // output an error message with a helpful prompt for the user
  }

  "extractAreaFromInput" - {
    // take the string and output the correct field in the db
    // allow for fuzzy matches???
    // if there is an error, pass onto the error function
  }

  "errorForIncorrectAreaParameterInput" - {
    // receive the incorrect user input
    // output an error message with a helpful prompt for the user
  }

  "databaseQuery" - {
    // we are given the correct field to query the db and all errors have been caught
    // query the database
    // return results from database
  }

  "returnResultsToUser" - {
    // we are given the results from the db
    // process this
    // print to STDOUT
  }

}
