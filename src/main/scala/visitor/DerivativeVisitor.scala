package cl.ravenhill.scrabble.dx
package visitor

import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

/** The `DerivativeVisitor` class is an implementation of the [[ExpressionVisitor]] trait
  * with the result type being [[Expression]]. It traverses an expression tree and calculates
  * the derivative of the expression according to basic calculus rules.
  *
  * This class takes an argument in its constructor, which is the variable with respect to which the
  * derivative is calculated. It is assumed that all instances of this variable in the expression
  * tree represent the same variable.
  *
  * @param differentiationVariable The variable with respect to which the derivative is to be
  *                                calculated.
  * @constructor Creates a new ``DerivativeVisitor`` with the given differentiation variable.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
class DerivativeVisitor(val differentiationVariable: Variable)
    extends ExpressionVisitor[Expression] {

  /** Calculates the derivative of an addition expression.
    *
    * The derivative of an addition expression is the sum of the derivatives of the individual terms.
    *
    * @param add The Add expression to differentiate.
    * @return The derivative of the Add expression.
    */
  override def visitAdd(add: Add): Add =
    Add(add.left.accept(this), add.right.accept(this))

  /** Calculates the derivative of a multiplication expression.
    *
    * The derivative of a multiplication expression (u * v) is given by (u' * v) + (u * v').
    *
    * @param multiply The Multiply expression to differentiate.
    * @return The derivative of the Multiply expression.
    */
  override def visitMultiply(multiply: Multiply): Add =
    Add(
      Multiply(multiply.left.accept(this), multiply.right),
      Multiply(multiply.left, multiply.right.accept(this))
    )

  /** Calculates the derivative of a real constant.
    *
    * The derivative of a constant real number is zero.
    *
    * @param real The Real constant to differentiate.
    * @return The derivative of the Real constant, which is always 0.
    */
  override def visitReal(real: Real): Integer = Integer(0)

  /** Calculates the derivative of an integer constant.
    *
    * The derivative of a constant integer number is zero.
    *
    * @param integer The Integer constant to differentiate.
    * @return The derivative of the Integer constant, which is always 0.
    */
  override def visitInteger(integer: Integer): Integer = Integer(0)

  /** Calculates the derivative of a variable.
    *
    * The derivative of a variable with respect to itself is one, with respect to any other variable
    * it is zero.
    *
    * @param variable The Variable to differentiate.
    * @return The derivative of the Variable.
    *         It returns 1 if the variable is the differentiation variable; otherwise, it returns 0.
    */
  override def visitVariable(variable: Variable): Integer =
    if (variable.index == differentiationVariable.index) Integer(1)
    else Integer(0)
}
