package cl.ravenhill.scrabble.dx
package expr.operators

import expr.Expression
import visitor.ExpressionVisitor

/** The Multiply case class represents a "multiplication" operation as a composite mathematical
  * expression.
  * It has a left and right expression as its operands.
  *
  * Multiply is a type of [[Expression]] and can be visited by an [[ExpressionVisitor]].
  * It also supports pattern matching.
  *
  * @constructor Creates a new Multiply expression with the given left and right operands.
  * @param left The left operand of the multiplication.
  * @param right The right operand of the multiplication.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
case class Multiply(left: Expression, right: Expression) extends Expression {

  /// Documentation inherited from [[[Expression]]].
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitMultiply(this)
}
