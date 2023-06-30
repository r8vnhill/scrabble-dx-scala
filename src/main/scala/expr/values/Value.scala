package cl.ravenhill.scrabble.dx
package expr.values

import expr.Expression

trait Value[+T] extends Expression {
  val value: T
}
