package cl.ravenhill.scrabble.dx
package expr

trait Value {
  val value: Any

  def add(that: Value): Value

  def addToInt(that: Integer): Value

  def addToReal(that: Real): Value
}
