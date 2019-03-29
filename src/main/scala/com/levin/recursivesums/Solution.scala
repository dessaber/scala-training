package com.levin.recursivesums

import java.io._

import scala.annotation.tailrec

object Solution {

  // no hacks solution
  def superDigit(n: String, k: Int): Int = {
    val m = superDigitHelper(n)
    superDigitHelper(m * k).toInt
  }

  @tailrec
  def superDigitHelper(n: String): String = {
    if (n.length == 1)
      n
    else
      superDigitHelper(n.split("").map(_.toLong).sum.toString)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0)

    val k = nk(1).trim.toInt

    val result = superDigit(n, k)

    printWriter.println(result)

    printWriter.close()
  }
}
