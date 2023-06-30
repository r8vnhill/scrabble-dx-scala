package cl.ravenhill.scrabble.dx
package expr

import visitor.ExpressionVisitor

trait Expression {
  def accept[T](visitor: ExpressionVisitor[T]): T
}
