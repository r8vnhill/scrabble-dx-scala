package cl.ravenhill.scrabble.dx
package matcher

import expr.{Expression, Variable}
import expr.operators._
import expr.values._

object DerivativeCalculator {
  def calculate(expression: Expression, variable: String): Expression = {
    expression match {
      case Add(left, right) =>
        Add(
          calculate(left, variable),
          calculate(right, variable)
        )
      case Multiply(left, right) =>
        Add(
          Multiply(calculate(left, variable), right),
          Multiply(left, calculate(right, variable))
        )
      case _: Value[_]       => Integer(0)
      case Variable(name, _) => Integer(0)
      case _ =>
        throw new UnknownExpressionException(expression)
    }
  }
}
