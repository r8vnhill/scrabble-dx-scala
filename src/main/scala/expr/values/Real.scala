package cl.ravenhill.scrabble.dx
package expr.values
import visitor.ExpressionVisitor

case class Real(override val value: Double) extends Value[Double] {
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitReal(this)
}
