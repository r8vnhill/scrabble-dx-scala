package cl.ravenhill.scrabble.dx
package visitor

import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

class DerivativeVisitor extends ExpressionVisitor[Expression] {
  override def visitAdd(add: Add): Add =
    Add(add.left.accept(this), add.right.accept(this))

  override def visitMultiply(multiply: Multiply): Add =
    Add(
      Multiply(multiply.left.accept(this), multiply.right),
      Multiply(multiply.left, multiply.right.accept(this))
    )

  override def visitReal(real: Real): Integer = Integer(0)

  override def visitInteger(integer: Integer): Integer = Integer(0)

  override def visitVariable(variable: Variable): Integer = Integer(1)
}
