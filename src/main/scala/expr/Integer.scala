package cl.ravenhill.scrabble.dx
package expr

class Integer(override val value: Int) extends Value {

  override def add(that: Value): Value = that.addToInt(this)

  override def addToInt(that: Integer): Value = new Integer(that.value + value)

  override def addToReal(that: Real): Value = new Real(that.value + value)
}
