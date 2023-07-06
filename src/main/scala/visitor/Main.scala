package cl.ravenhill.scrabble.dx
package visitor

import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}
import expr.Variable

/** The `Main` object is the entry point for the application.
 * It defines some mathematical expressions, prints them, and then calculates and prints their
 * derivatives with respect to a specified variable.
 *
 * This example demonstrates the use of the visitor design pattern in implementing expression trees
 * and differentiating expressions with respect to a specific variable.
 */
object Main {
  def main(args: Array[String]): Unit = {
    // Define some expressions
    val x = Variable("x", 1)
    val y = Variable("y", 2)
    val expr1 = Multiply(Add(x, Integer(5)), Real(3.0))
    val expr2 = Add(Multiply(x, x), y)
    val printVisitor = new PrintVisitor()

    // Print the original expressions
    println("Expression 1:")
    expr1.accept(printVisitor)
    println()

    println("Expression 2:")
    expr2.accept(printVisitor)
    println()

    // Calculate and print the derivatives
    val derivativeVisitorX = new DerivativeVisitor(x)

    println("Derivative of Expression 1 with respect to x:")
    val derivative1 = expr1.accept(derivativeVisitorX)
    derivative1.accept(printVisitor)
    println()

    println("Derivative of Expression 2 with respect to x:")
    val derivative2 = expr2.accept(derivativeVisitorX)
    derivative2.accept(printVisitor)
  }
}
