package cl.ravenhill.scrabble.dx

import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

import cl.ravenhill.scrabble.dx.matcher.ExpressionPrinter
import cl.ravenhill.scrabble.dx.visitor.PrintVisitor

object Main {
  def main(args: Array[String]): Unit = {
    val expression = Add(Multiply(Real(1.5), Integer(2)), Integer(3))
    ExpressionPrinter.printExpr(expression)
    // ((1.5 * 2) + 3)
  }
}
