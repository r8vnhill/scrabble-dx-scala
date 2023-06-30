package cl.ravenhill.scrabble.dx
package expr.operators

import expr.Expression
import visitor.ExpressionVisitor

case class Add(val left: Expression, val right: Expression)
    extends Expression {
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitAdd(this)
}

