import early.EarlyYearsApi.validateAgeInput
import org.scalatest.{FreeSpec, FunSuite, Matchers}
import org.scalatestplus.play.PlaySpec

class earlyYearsApiTest extends FreeSpec with Matchers {
  "validateAgeInput" in {
    "returns 0 if given the String 0" in {
      validateAgeInput("0") shouldEqual 0
    }
  }
}
