package cl.ravenhill.scrabble.dx
package caseclasses.manual

import java.util.Objects

/**
 * Represents a case class equivalent with manual implementation.
 *
 * This class has the same functionality as a Scala case class. It includes:
 * - Parameter fields
 * - An `equals` method for value-based equality checking
 * - A `hashCode` method for providing a hash based on the values of the parameters
 * - A `toString` method for creating a string representation
 * - A `copy` method for creating a new object with the same or modified parameters
 *
 * @param a The first parameter of the class.
 * @param b The second parameter of the class.
 */
class CaseClass(val a: Int, val b: Int) {
  /**
   * Checks if another object is equal to this one based on the values of the parameters `a` and `b`.
   *
   * @param obj The object to be compared with.
   * @return `true` if the other object is a `CaseClass` with the same `a` and `b` values, `false` otherwise.
   */
  override def equals(obj: Any): Boolean = obj match {
    case CaseClass(a, b) => this.a == a && this.b == b
    case _               => false
  }

  /**
   * Provides a hash based on the values of the parameters `a` and `b`.
   *
   * @return The hash code.
   */
  override def hashCode(): Int = Objects.hash(a, b)

  /**
   * Creates a string representation of the `CaseClass`.
   *
   * @return The string representation.
   */
  override def toString: String = s"CaseClass($a, $b)"

  /**
   * Creates a new `CaseClass` object with the same or modified parameters.
   *
   * @param a The new value for parameter `a`, defaults to the current value.
   * @param b The new value for parameter `b`, defaults to the current value.
   * @return A new `CaseClass` object.
   */
  def copy(a: Int = this.a, b: Int = this.b): CaseClass =
    new CaseClass(a, b)
}

/**
 * Companion object for the `CaseClass` class.
 * Provides apply and unapply methods for creating and deconstructing `CaseClass` objects.
 */
object CaseClass {
  /**
   * Creates a new `CaseClass` object.
   *
   * @param a The value for parameter `a`.
   * @param b The value for parameter `b`.
   * @return A new `CaseClass` object.
   */
  def apply(a: Int, b: Int): CaseClass = new CaseClass(a, b)

  /**
   * Deconstructs a `CaseClass` object.
   *
   * @param arg The `CaseClass` object to deconstruct.
   * @return An `Option` containing a tuple with the values of the parameters `a` and `b`.
   */
  def unapply(arg: CaseClass): Option[(Int, Int)] = Some(arg.a, arg.b)
}

