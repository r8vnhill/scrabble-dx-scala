package cl.ravenhill.scrabble.dx
package visitor
import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values._

class PrintVisitor extends ExpressionVisitor[Unit] {
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

  override def visitInteger(integer: Integer): Unit = print(integer.value)

  override def visitReal(real: Real): Unit = print(real.value)

  override def visitAdd(add: Add): Unit =
    visitBinaryOperation("+", add.left, add.right)

  override def visitMultiply(product: Multiply): Unit =
    visitBinaryOperation("*", product.left, product.right)

  override def visitVariable(variable: Variable): Unit = print(variable.name)
}
