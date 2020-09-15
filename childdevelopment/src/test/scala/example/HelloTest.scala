package example

import example.Hello.{childDevelopment, extractAgeFromInput}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloTest extends AnyFreeSpec with Matchers {
  "extractAgeFromInput" - {
    "returns 0 for an input of 7" in {
      extractAgeFromInput(7) shouldEqual 0
    }
    "returns an error for an input of 60" in {
      a[RuntimeException] should be thrownBy extractAgeFromInput(60)
    }
  }
}
