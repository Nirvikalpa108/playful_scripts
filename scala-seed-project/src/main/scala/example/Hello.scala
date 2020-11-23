package example

object Hello {
//  def main(args: Array[String]): Unit = {
//    val firstArg: String = args.head
//    val w: String = "winning"
//    val i = 1
//    val j = 2
//    i + j
//  }

  def addTwo(a: Int, b: Int): Int = {
    a + b
  }

  def nestedFunctions(): Unit = {
    // println(add(7, 8))
    println(constOne(true))
    println(constTwo(1, false))
    val tmp = constTwo(2, 3)
    val t = tmp(1)
    println(tmp(1))
    val alwaysABC = const("abc")
    println(alwaysABC("ggg"))
    println(constThree(5)(2))
    // triple nested
    val a = constFive(2)
    val b = a(3)
    val c = b(4)
    println(c)
    // with calculations
    val d = constSeven(3)
    val e = d(4)
    println(e)
    // triple nested calculations
    val f = constNine(100)
    val g = f(1000)
    val h = g(2)
    println(h)
  }

  def add(a: Int, b: Int): Int = a + b

  def first(n: List[Int]): Int = n.head

  def first(s: List[String]): String = s.head

  def first(b: List[Boolean]): Boolean = b.head

  def first[T](t: List[T]): T = t.head

  first(List(true))

  first[Boolean](List(false))

  def constOne[A](a: A): Int = 1

  def constTwo[A, B](a: A, b: B): A => A = {
    def aToA(a: A): A = a
    aToA
  }

  def const[A](a: A): A => A = {
    def b(c: A): A = a
    b
  }

  def constThree[A](a: A): A => A = { c =>
    a
  }

  def constFour[A](a: A): A => A = (c => a)

  // triple nested
  def constFive[A](a: A): A => A => A = (a => a => a)

  def constSix[A, B, C](a: A, b: B, c: C): A => B => C = (a => b => c)

  // with calculations
  def constSeven(a: Int): Int => Int = a => a * 2

  def constEight(a: Int): Int => Int => Int = a => a => a * a

  def constNine(a: Int): Int => Int => Int = a => b => b * b
}