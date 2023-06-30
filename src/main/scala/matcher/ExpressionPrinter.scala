package cl.ravenhill.scrabble.dx
package matcher

import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

object ExpressionPrinter {
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

  def printExpr(expression: Expression): Unit = {
    expression match {
      case Add(left, right) =>
        printBinOp("+", left, right)
      case Multiply(left, right) =>
        printBinOp("*", left, right)
      case Integer(i) => print(i)
      case Real(r)    => print(r)
      case Variable(name, _) => print(name)
      case _ =>
        throw new UnknownExpressionException(expression)
    }
  }
}
