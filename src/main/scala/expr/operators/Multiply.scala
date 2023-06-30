package cl.ravenhill.scrabble.dx
package expr.operators

import expr.Expression
import visitor.ExpressionVisitor

case class Multiply(left: Expression, right: Expression)
    extends Expression {
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitMultiply(this)
}
