// https://www.playframework.com/documentation/2.8.x/ScalaTestingWithScalaTest
import controllers.HomeController
import org.scalatestplus.play._

class homeControllerSpec extends PlaySpec {
  "validateAgeInput" in {
    "returns 0 if given the String 0" in {
      validateAgeInput("0") shouldEqual 0
    }
  }
}

