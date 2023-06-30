
package cl.ravenhill.scrabble.dx
package expr

import visitor.ExpressionVisitor

case class Variable (name: String, index: Int) extends Expression {
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitVariable(this)
}
