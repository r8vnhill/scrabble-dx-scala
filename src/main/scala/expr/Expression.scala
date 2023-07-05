package cl.ravenhill.scrabble.dx
package expr

import visitor.ExpressionVisitor

/** The Expression trait represents a mathematical expression, modeled as a composite.
  *
  * An expression can be a constant (like an integer or a real number), a variable, or a composite of
  * other expressions, such as a binary operation (Add, Multiply, etc.).
  *
  * The Expression trait allows the use of the Visitor design pattern to perform operations over
  * expressions, such as evaluation, simplification, differentiation, printing, etc.
  *
  * It also allows matching expressions using pattern matching.
  */
trait Expression {

  /** Accepts a visitor, enabling it to visit the expression.
    *
    * This method is a part of the Visitor design pattern. It allows a visitor to visit the
    * expression and potentially return a result. The type of the result is determined by the
    * specific visitor.
    *
    * @param visitor The visitor that is to visit the expression.
    * @return The result of the visitor visiting the expression. The type of the result is
    *         determined by the specific visitor.
    */
  def accept[T](visitor: ExpressionVisitor[T]): T
}
