package cl.ravenhill.scrabble.dx
package matcher

import expr.Expression

/** The `UnknownExpressionException` class represents an exception thrown when encountering
 * an unknown or unsupported type of [[Expression]] during expression processing.
 *
 * @constructor Creates a new `UnknownExpressionException` with a given [[Expression]].
 * @param expression The [[Expression]] which is unknown or unsupported.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
class UnknownExpressionException(expression: Expression) extends Exception(
  s"Unknown expression: $expression")
