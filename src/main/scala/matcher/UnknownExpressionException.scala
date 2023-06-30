package cl.ravenhill.scrabble.dx
package matcher

import expr.Expression

class UnknownExpressionException(expression: Expression) extends Exception(
  s"Unknown expression: $expression")
