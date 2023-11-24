package cl.ravenhill.scrabble.dx
package expr

trait Value[T] extends Expression {
  val value: T
}
