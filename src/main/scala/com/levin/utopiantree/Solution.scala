package com.levin.utopiantree

import java.io._

object Solution {

  // Complete the utopianTree function below.
  def utopianTree(n: Int): Int = {
    add(0, n)
  }

  def multiply(acc: Int, n: Int): Int = {
    if (n >= 0)
      add(acc * 2, n - 1)
    else
      acc
  }


  def add(acc: Int, n: Int): Int = {
    if (n >= 0)
      multiply(acc + 1, n - 1)
    else
      acc
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val result = utopianTree(n)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
