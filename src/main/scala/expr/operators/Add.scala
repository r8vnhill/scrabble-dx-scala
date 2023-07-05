package cl.ravenhill.scrabble.dx
package expr.operators

import expr.Expression
import visitor.ExpressionVisitor

/** The Add case class represents an "addition" operation as a composite mathematical expression.
  * It has a left and right expression as its operands.
  *
  * Add is a type of [[Expression]] and can be visited by an ExpressionVisitor.
  * It also supports pattern matching.
  *
  * @constructor Creates a new Add expression with the given left and right operands.
  * @param left The left operand of the addition.
  * @param right The right operand of the addition.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
case class Add(left: Expression, right: Expression) extends Expression {

  /// Documentation inherited from [[[Expression]]].
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitAdd(this)
}
