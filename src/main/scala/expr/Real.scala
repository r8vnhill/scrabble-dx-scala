package cl.ravenhill.scrabble.dx
package expr

class Real(override val value: Double) extends Value {

  override def add(that: Value): Value = that.addToReal(this)

  override def addToInt(that: Integer): Value = new Real(that.value + value)

  override def addToReal(that: Real): Value = new Real(that.value + value)

  override def multiply(that: Value): Value = that.multiplyByReal(this)

  override def multiplyByInt(that: Integer): Value = new Real(that.value * value)

  override def multiplyByReal(that: Real): Value = new Real(that.value * value)
}
