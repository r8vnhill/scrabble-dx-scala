package cl.ravenhill.scrabble.dx
package matcher

import expr.Expression
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

object ExpressionReducer {
  // Definition of the common behavior for binary operations
  private def processBinaryOperation(
      operation: (Double, Double) => Double,
      factory: (Expression, Expression) => Expression,
      left: Expression,
      right: Expression
  ): Expression = {
    val reduced = (reduce(left), reduce(right))
    reduced match {
      case (Integer(l), Integer(r)) => Integer(operation(l, r).toInt)
      case (Integer(l), Real(r))    => Real(operation(l, r))
      case (Real(l), Integer(r))    => Real(operation(l, r))
      case (Real(l), Real(r))       => Real(operation(l, r))
      case _                        => factory(left, right)
    }
  }

  def reduce(expression: Expression): Expression = {
    expression match {
      case Add(left, right) =>
        processBinaryOperation(_ + _, Add, left, right)
      case Multiply(left, right) =>
        processBinaryOperation(_ * _, Multiply, left, right)
      case _ => expression
    }
  }
}
