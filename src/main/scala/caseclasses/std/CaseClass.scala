package cl.ravenhill.scrabble.dx
package caseclasses.std

/** Represents a simple case class with two integer parameters.
  *
  * Case classes in Scala are a type of class that come with some useful default methods.
  * However, for demonstrating purposes, those methods are manually overridden and implemented here.
  *
  * @param a The first parameter of the case class.
  * @param b The second parameter of the case class.
  */
case class CaseClass(a: Int, b: Int)

/**
  * Companion object for the `CaseClass` class.
  * It provides usage examples for the `CaseClass` class.
  */
object CaseClass {
  def main(args: Array[String]): Unit = {
    CaseClass(1, 2) match {
      case CaseClass(a, b) => println(s"CaseClass($a, $b)")
    }
  }
}