package com.levin.drawingbook

import java.io.PrintWriter

object Solution {

  /*
   * Complete the pageCount function below.
   */

  def pageCount(n: Int, p: Int): Int = {
    val actualPage = p / 2
    List(actualPage, n / 2 - actualPage).min
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val p = stdin.readLine.trim.toInt

    val result = pageCount(n, p)

    println(result)
    printWriter.println(result)

    printWriter.close()
  }
}
