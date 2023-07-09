package cl.ravenhill.scrabble.dx
package matcher

import expr.{Expression, Variable}
import expr.operators._
import expr.values._

/** The `DerivativeCalculator` object provides a utility function to calculate the derivative
  * of various kinds of [[Expression]] instances with respect to a given variable.
  * It uses pattern matching to identify and properly differentiate each type of `Expression`.
  *
  * @note This object handles [[Add]], [[Multiply]], [[Value]], and [[Variable]]
  *       expressions. It calculates the derivative using basic calculus rules.
  *       If an expression type is unknown, an [[UnknownExpressionException]] is thrown.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
object DerivativeCalculator {

  /** Public method to calculate the derivative of any expression with respect to a given variable.
    * This method uses pattern matching to identify the type of the expression and then calculates
    * its derivative.
    * If the expression type is unknown, it throws an [[UnknownExpressionException]].
    *
    * @param expression The expression to be differentiated.
    * @param variable The variable with respect to which the differentiation is performed.
    * @return The derivative of the expression.
    * @throws UnknownExpressionException If the expression type is unknown.
    */
  def calculate(expression: Expression, variable: Variable): Expression = {
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
      case _: Value[_] => Integer(0)
      case Variable(_, index) =>
        if (variable.index == index) Integer(1) else Integer(0)
      case _ =>
        throw new UnknownExpressionException(expression)
    }
  }
}
