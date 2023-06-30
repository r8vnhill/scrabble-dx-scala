package cl.ravenhill.scrabble.dx
package expr.values
import visitor.ExpressionVisitor

case class Integer(override val value: Int) extends Value[Int] {
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitInteger(this)
}
