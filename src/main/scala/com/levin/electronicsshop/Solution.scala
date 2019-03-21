package com.levin.electronicsshop

import java.io.PrintWriter

object Solution {

  /*
   * Complete the getMoneySpent function below.
   */
  def getMoneySpent(keyboards: Array[Int], drives: Array[Int], b: Int): Int = {
    /*
     * Write your code here.
     */
    val combinationsIter = (for {k <- keyboards; d <- drives} yield (k, d, k + d)).sortBy(x => -x._3)
      .map(x => x._3)
      .filter(_ <= b)
      .iterator

    if (combinationsIter.isEmpty)
      -1
    else
      combinationsIter.next()
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val bnm = stdin.readLine.split(" ")

    val b = bnm(0).trim.toInt

    val n = bnm(1).trim.toInt

    val m = bnm(2).trim.toInt

    val keyboards = stdin.readLine.split(" ").map(_.trim.toInt)

    val drives = stdin.readLine.split(" ").map(_.trim.toInt)
    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
    printWriter.println(moneySpent)

    printWriter.close()
  }
}
