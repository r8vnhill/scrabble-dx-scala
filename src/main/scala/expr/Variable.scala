package cl.ravenhill.scrabble.dx
package expr

import visitor.ExpressionVisitor

/** The `Variable` case class represents a variable within a mathematical expression in the
  * expression tree.
  * A `Variable` is characterized by its `name` and an `index`, which can be used to differentiate
  * between multiple instances of the same variable within an expression.
  *
  * The `Variable` class provides an implementation for the accept method that takes an instance of
  * [[ExpressionVisitor]] and invokes its `visitVariable` method, passing in the current `Variable`
  * instance.
  * This mechanism is a part of the Visitor design pattern used for processing expressions.
  *
  * As a case class, `Variable` supports pattern matching, which can be useful when dealing with
  * instances of this class.
  *
  * @param name The name of the variable.
  * @param index The index of the variable, used to distinguish between multiple instances of the
  *              same variable.
  * @constructor Creates a new instance of `Variable` with a given name and index.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
case class Variable(name: String, index: Int) extends Expression {
  /// Documentation inherited from [[Expression]].
  override def accept[T](visitor: ExpressionVisitor[T]): T =
    visitor.visitVariable(this)
}
