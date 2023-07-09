package cl.ravenhill.scrabble.dx
package matcher

import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

/** The `ExpressionPrinter` object provides utility functions for representing various
  * kinds of [[Expression]] instances in a human-readable format.
  * It uses pattern matching to identify and appropriately format each type of `Expression`.
  *
  * @note This object handles [[Add]], [[Multiply]], [[Integer]], [[Real]], and [[Variable]]
  *       expressions. An expression is considered "unknown" if it does not fall into one of
  *       these categories. If an unknown type of expression is encountered, an [[UnknownExpressionException]] is
  *       thrown.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
object ExpressionPrinter {

  /** Private method to print binary operations in a standardized format.
    * This format is "(left_operand operator right_operand)".
    *
    * @param sym The symbol of the binary operator.
    * @param left The left operand expression.
    * @param right The right operand expression.
    */
  private def printBinOp(
      sym: String,
      left: Expression,
      right: Expression
  ): Unit = {
    print("(")
    printExpr(left)
    print(s" $sym ")
    printExpr(right)
    print(")")
  }

  /** Public method to represent any expression in a human-readable format.
    * This method uses pattern matching to identify the type of the expression and then print it.
    * If the expression type is unknown (i.e., not one of [[Add]], [[Multiply]], [[Integer]],
    * [[Real]], or [[Variable]]), it throws an [[UnknownExpressionException]].
    *
    * @param expression The expression to be printed.
    * @throws UnknownExpressionException If the expression type is unknown.
    */
  def printExpr(expression: Expression): Unit = {
    expression match {
      case Add(left, right) =>
        printBinOp("+", left, right)
      case Multiply(left, right) =>
        printBinOp("*", left, right)
      case Integer(i)        => print(i)
      case Real(r)           => print(r)
      case Variable(name, _) => print(name)
      case _ =>
        throw new UnknownExpressionException(expression)
    }
  }
}
