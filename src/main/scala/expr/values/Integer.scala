package cl.ravenhill.scrabble.dx
package expr.values
import visitor.ExpressionVisitor

/**
 * The `Integer` case class represents a mathematical integer value in the expression tree.
 * It extends from the [[Value]] trait with the type parameter [[Int]], indicating it holds an
 * integer value.
 *
 * The `Integer` class also provides an accept method implementation that takes an
 * [[ExpressionVisitor]] and calls its `visitInteger` method, passing in the
 * current `Integer` instance.
 * This is a part of the visitor design pattern used for processing expressions.
 *
 * As a case class, `Integer` supports pattern matching out of the box, providing added
 * flexibility when working with instances of this class.
 *
 * @param value The integer value this instance represents.
 * @constructor Creates an instance of `Integer` with a given integer value.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
case class Integer(override val value: Int) extends Value[Int] {
  /// Documentation inherited from [[Expression]].
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitInteger(this)
}
