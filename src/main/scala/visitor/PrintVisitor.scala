package cl.ravenhill.scrabble.dx
package visitor
import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values._

/** The `PrintVisitor` class is an implementation of the [[ExpressionVisitor]] trait where the result
  * type is [[Unit]].
  * It traverses the expression tree and prints the expression in an infix notation.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
class PrintVisitor extends ExpressionVisitor[Unit] {

  /** Private method to print binary operations in a standardized format.
    *
    * @param op The operator, as a string, to be printed between the left and right expressions.
    * @param left The left operand expression.
    * @param right The right operand expression.
    */
  private def visitBinaryOperation(
      op: String,
      left: Expression,
      right: Expression
  ): Unit = {
    print("(")
    left.accept(this)
    print(s" $op ")
    right.accept(this)
    print(")")
  }

  /// Documentation inherited from [[ExpressionVisitor]].
  override def visitInteger(integer: Integer): Unit = print(integer.value)

  /// Documentation inherited from [[ExpressionVisitor]].
  override def visitReal(real: Real): Unit = print(real.value)

  /// Documentation inherited from [[ExpressionVisitor]].
  override def visitAdd(add: Add): Unit =
    visitBinaryOperation("+", add.left, add.right)

  /// Documentation inherited from [[ExpressionVisitor]].
  override def visitMultiply(product: Multiply): Unit =
    visitBinaryOperation("*", product.left, product.right)

  /// Documentation inherited from [[ExpressionVisitor]].
  override def visitVariable(variable: Variable): Unit = print(variable.name)
}
