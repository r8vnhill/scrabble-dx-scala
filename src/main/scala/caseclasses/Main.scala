
package cl.ravenhill.scrabble.dx
package caseclasses

object Main {
  def main(args: Array[String]): Unit = {
    println("=== Case class ===")
    val stdCc = std.CaseClass(1, 2)
    val manualCc = manual.CaseClass(1, 2)
    println(s"stdCc = $stdCc")
    println(s"manualCc = $manualCc")
    println("--- Equals ---")
    val stdEq = std.CaseClass(1, 2)
    val manualEq = manual.CaseClass(1, 2)
    println(s"stdEq == stdCc = ${stdEq == stdCc}")
    println(s"manualEq == manualCc = ${manualEq == manualCc}")
    println("--- Hash ---")
    val stdHash = std.CaseClass(1, 2)
    val manualHash = manual.CaseClass(1, 2)
    println(s"stdHash.## == stdCc.## = ${stdHash.## == stdCc.##}")
    println(s"manualHash.## == manualCc.## = ${manualHash.## == manualCc.##}")
    println(s"stdHash.## == manualHash.## = ${stdHash.## == manualHash.##}")
  }
}
