package cl.ravenhill.scrabble.dx
package expr.values

import expr.Expression

/** The Value trait represents an Expression that holds a single value.
  * This trait is used as the base for classes that represent literal values in mathematical
  * expressions.
  *
  * This trait extends the [[Expression]] trait and is covariant in its type parameter [[T]].
  *
  * @tparam T The type of the value held by a class extending Value.
  *           The + symbol indicates that Value is covariant in its type parameter.
  */
trait Value[+T] extends Expression {

  /** The value held by a class extending Value.
    * The type of the value is T.
    */
  val value: T
}

/*
  Suppose `T` was not covariant in the `Value` trait.
  In this case, we wouldn't be able to use a `Value[ParentType]` where a `Value[ChildType]` is
  expected, even though `ChildType` is a subtype of `ParentType`.

  Here is an example scenario where this could become a problem:

  Consider two classes `Animal` and `Dog`, where `Dog` is a subclass of `Animal`.

  ```scala
  class Animal {
    def makeSound(): Unit = println("Generic animal sound")
  }

  class Dog extends Animal {
    override def makeSound(): Unit = println("Woof!")
  }
  ```

  If you tried to create a method that accepts a `Value[Animal]` and you tried to pass in a
  `Value[Dog]`, you would get a type error if `Value` was not covariant.

  ```scala
  def printAnimalSound(value: Value[Animal]): Unit = {
    value.value.makeSound()
  }

  val dogValue: Value[Dog] = new Value[Dog] {
    val value = new Dog
  }

  // This would result in a compile-time error if T in Value[+T] was not covariant
  printAnimalSound(dogValue)
  ```

  The call to `printAnimalSound(dogValue)` would not be allowed because `Value[Dog]` is not a
  subtype of `Value[Animal]` when `T` is not covariant.
  However, it is intuitive to think that we should be able to pass a `Value[Dog]` to a method that
  accepts `Value[Animal]` since `Dog` is a subtype of `Animal`.
  To allow this, we need to make `T` covariant by declaring the trait as `Value[+T]`.
 */
