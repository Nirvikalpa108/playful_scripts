package example

import scala.util.control.NonFatal

object Calculator {
  def main(args: Array[String]): Unit = {
    try {
      val operator = args(1)
      val firstDigit = args.head.toFloat
      val secondDigit = args(2).toFloat
      val result = matchIt(operator, firstDigit, secondDigit)
      println(result)
    } catch {
      case NonFatal(t) => 
        println("Sorry, that didn't work! Here are some example commands you can run: 1 + 1, 2 - 1, 2 * 2, 4 / 2", t)
    }
  }

  def ifIt(operator: String, firstDigit: Int, secondDigit: Int): Int = {
    if (operator == "+") firstDigit + secondDigit
    else firstDigit - secondDigit
  }

  def matchIt(operator: String, firstDigit: Float, secondDigit: Float): Float = { operator match {
      case "+" => firstDigit + secondDigit
      case "-" => firstDigit - secondDigit
      case "/" => firstDigit / secondDigit
      case "*" => firstDigit * secondDigit
    }
  }
}
