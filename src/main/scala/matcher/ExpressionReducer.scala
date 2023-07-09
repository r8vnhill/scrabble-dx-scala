package cl.ravenhill.scrabble.dx
package matcher

import expr.Expression
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

/** The `ExpressionReducer` object provides utility functions to reduce or simplify
  * various kinds of [[Expression]] instances.
  * It uses pattern matching to identify and properly reduce each type of [[Expression]].
  *
  * @note This object handles [[Add]], [[Multiply]], [[Integer]], and [[Real]]
  *       expressions.
  *       Reduction or simplification is performed using basic mathematical operations, when
  *       possible.
  *       If an expression can't be simplified, it is returned unchanged.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
object ExpressionReducer {

  /** Private method to process binary operations and reduce them, if possible.
    *
    * @param operation The mathematical operation to be performed.
    * @param factory The constructor for the binary operation.
    * @param left The left operand expression.
    * @param right The right operand expression.
    * @return The simplified binary operation, or the original operation if it cannot be simplified.
    */
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

  /** Public method to reduce or simplify any expression.
    * This method uses pattern matching to identify the type of the expression and then attempts to
    * reduce it.
    * If the expression type can't be reduced, the original expression is returned.
    *
    * @param expression The expression to be reduced.
    * @return The reduced or simplified expression, or the original expression if it cannot be
    *         simplified.
    */
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
