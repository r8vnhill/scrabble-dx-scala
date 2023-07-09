package cl.ravenhill.scrabble.dx
package matcher

import expr.Variable
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

object Main {
  def main(args: Array[String]): Unit = {
    // Define some expressions
    val x = Variable("x", 1)
    val y = Variable("y", 2)
    val expr1 = Multiply(Add(x, Integer(5)), Real(3.0))
    val expr2 = Add(Multiply(x, x), y)

    // Print the original expressions
    println("Expression 1:")
    ExpressionPrinter.printExpr(expr1)
    println()

    println("Expression 2:")
    ExpressionPrinter.printExpr(expr2)
    println()

    println("Derivative of Expression 1 with respect to x:")
    val derivative1 = DerivativeCalculator.calculate(expr1, x)
    val reducedDerivative1 = ExpressionReducer.reduce(derivative1)
    ExpressionPrinter.printExpr(reducedDerivative1)
    println()

    println("Derivative of Expression 2 with respect to x:")
    val derivative2 = DerivativeCalculator.calculate(expr2, x)
    val reducedDerivative2 = ExpressionReducer.reduce(derivative2)
    ExpressionPrinter.printExpr(reducedDerivative2)
  }
}
