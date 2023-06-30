package cl.ravenhill.scrabble.dx
package visitor

import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}
import expr.Variable

trait ExpressionVisitor[+T] {
  def visitVariable(variable: Variable): T
  def visitInteger(integer: Integer): T
  def visitReal(real: Real): T
  def visitAdd(add: Add): T
  def visitMultiply(product: Multiply): T
}
