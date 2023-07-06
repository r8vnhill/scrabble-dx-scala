package cl.ravenhill.scrabble.dx
package visitor

import expr.{Expression, Variable}
import expr.operators.{Add, Multiply}
import expr.values.{Integer, Real}

/** The `ExpressionVisitor` trait represents a Visitor in the Visitor design pattern.
  * This trait provides an interface for performing some operation (or "visit") on various kinds of
  * [[Expression]] objects.
  * Each method corresponds to a visit operation for a specific [[Expression]] subtype.
  *
  * This trait is parameterized by a covariant type `T`, which represents the type of the result
  * produced by the visit methods.
  * This allows the Visitor to produce results of various types depending on the specific
  * implementation of the Visitor.
  *
  * @tparam T The result type of the visitor.
  *           It's covariant, which allows a visitor of a supertype to be used where a visitor of a
  *           subtype is expected.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
trait ExpressionVisitor[+T] {

  /** Visit a [[Variable]] expression.
    *
    * @param variable The Variable expression to visit.
    * @return The result of visiting the Variable expression.
    */
  def visitVariable(variable: Variable): T

  /** Visit an [[Integer]] expression.
    *
    * @param integer The Integer expression to visit.
    * @return The result of visiting the Integer expression.
    */
  def visitInteger(integer: Integer): T

  /** Visit a [[Real]] expression.
    *
    * @param real The Real expression to visit.
    * @return The result of visiting the Real expression.
    */
  def visitReal(real: Real): T

  /** Visit an [[Add]] expression.
    *
    * @param add The Add expression to visit.
    * @return The result of visiting the Add expression.
    */
  def visitAdd(add: Add): T

  /** Visit a [[Multiply]] expression.
    *
    * @param product The Multiply expression to visit.
    * @return The result of visiting the Multiply expression.
    */
  def visitMultiply(product: Multiply): T
}
