package cl.ravenhill.scrabble.dx
package expr

class Real(override val value: Double) extends Value {

  override def add(that: Value): Value = that.addToReal(this)

  override def addToInt(that: Integer): Value = new Real(that.value + value)

  override def addToReal(that: Real): Value = new Real(that.value + value)
}
