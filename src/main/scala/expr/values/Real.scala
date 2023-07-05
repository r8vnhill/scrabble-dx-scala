package cl.ravenhill.scrabble.dx
package expr.values
import visitor.ExpressionVisitor

/**
 * The `Real` case class represents a mathematical real number in the expression tree.
 * It extends from the [[Value]] trait with the type parameter [[Double]], indicating it holds a
 * double-precision floating point number.
 *
 * The `Real` class also provides an implementation for the accept method, which takes an instance
 * of [[ExpressionVisitor]] and calls its `visitReal` method with the current `Real` instance as
 * argument.
 * This mechanism is a part of the Visitor design pattern used for processing expressions.
 *
 * As a case class, `Real` supports pattern matching out of the box, providing added flexibility
 * when working with instances of this class.
 *
 * @param value The double-precision floating point number this instance represents.
 * @constructor Creates an instance of `Real` with a given double-precision floating point number.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
case class Real(override val value: Double) extends Value[Double] {
  /// Documentation inherited from [[Expression]].
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitReal(this)
}

