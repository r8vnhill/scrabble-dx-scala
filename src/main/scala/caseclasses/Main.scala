package cl.ravenhill.scrabble.dx
package caseclasses

/** Main object serves as the application's entry point.
  * It demonstrates how standard and manually implemented case classes function and differ.
  */
object Main {

  /** Prints the string representations of the provided standard and manually implemented case class instances.
    * @param stdCc The instance of the standard case class.
    * @param manualCc The instance of the manually implemented case class.
    */
  private def printToString(
      stdCc: std.CaseClass,
      manualCc: manual.CaseClass
  ): Unit = {
    println("--- toString ---")
    println(s"std.toString = $stdCc")
    println(s"manual.toString = $manualCc")
  }

  /** Prints the results of equality checks between standard and manually implemented case class instances.
    * @param stdCc The instance of the standard case class.
    * @param manualCc The instance of the manually implemented case class.
    */
  private def printEquals(
      stdCc: std.CaseClass,
      manualCc: manual.CaseClass
  ): Unit = {
    println("--- Equals ---")
    val stdEq = std.CaseClass(1, 2)
    val manualEq = manual.CaseClass(1, 2)
    println(s"stdEq == stdCc = ${stdEq == stdCc}")
    println(s"manualEq == manualCc = ${manualEq == manualCc}")
  }

  /** Prints the results of hash code checks between standard and manually implemented case class instances.
    * @param stdCc The instance of the standard case class.
    * @param manualCc The instance of the manually implemented case class.
    */
  private def printHash(
      stdCc: std.CaseClass,
      manualCc: manual.CaseClass
  ): Unit = {
    println("--- Hash ---")
    val stdHash = std.CaseClass(1, 2)
    val manualHash = manual.CaseClass(1, 2)
    println(s"stdHash.## == stdCc.## = ${stdHash.## == stdCc.##}")
    println(s"manualHash.## == manualCc.## = ${manualHash.## == manualCc.##}")
    // The hash code is not the same for the two classes, but it is consistent
    // with the equals method.
    println(s"stdHash.## == manualHash.## = ${stdHash.## == manualHash.##}")
  }

  /** Prints the results of copy operations for the standard and manually implemented case class instances.
    * @param stdCc The instance of the standard case class.
    * @param manualCc The instance of the manually implemented case class.
    */
  private def printCopy(
      stdCc: std.CaseClass,
      manualCc: manual.CaseClass
  ): Unit = {
    println("--- Copy ---")
    val stdCopy = stdCc.copy(a = 3)
    val manualCopy = manualCc.copy(a = 3)
    println(s"stdCopy = $stdCopy")
    println(s"manualCopy = $manualCopy")
  }

  /** Prints the results of the apply operations for the standard and manually implemented case class.
    */
  private def printApply(): Unit = {
    println("--- Apply ---")
    val stdApply = std.CaseClass(1, 2)
    val manualApply = manual.CaseClass(1, 2)
    println(s"stdApply = $stdApply")
    println(s"manualApply = $manualApply")
  }

  /** Prints the results of the unapply operations for the standard and manually implemented case class instances.
    * @param stdCc The instance of the standard case class.
    * @param manualCc The instance of the manually implemented case class.
    */
  private def printUnapply(
      stdCc: std.CaseClass,
      manualCc: manual.CaseClass
  ): Unit = {
    println("--- Unapply ---")
    val stdUnapply = std.CaseClass.unapply(stdCc)
    val manualUnapply = manual.CaseClass.unapply(manualCc)
    println(s"stdUnapply = $stdUnapply")
    println(s"manualUnapply = $manualUnapply")
  }

  /** The main method. It instantiates the standard and manually implemented case class,
    * then prints the results of several operations such as `toString`, `equals`, `hashCode`,
    * `copy`, `apply`, and `unapply`.
    * @param args Command-line arguments.
    */
  def main(args: Array[String]): Unit = {
    println("=== Case class ===")
    val stdCc = new std.CaseClass(1, 2)
    val manualCc = new manual.CaseClass(1, 2)
    printToString(stdCc, manualCc)
    printEquals(stdCc, manualCc)
    printHash(stdCc, manualCc)
    printCopy(stdCc, manualCc)
    printApply()
    printUnapply(stdCc, manualCc)
  }
}
