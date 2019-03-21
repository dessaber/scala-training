package com.levin.specialpalindrome

import java.io._

object Solution {

  // Complete the substrCount function below.
  def substrCount(n: Int, s: String): Long = {
    val pals =
      for {
        lengths <- 1 to s.length
        starts <- 0 to s.length - lengths
      } yield isPalindrome(s.substring(starts, starts + lengths))
    pals.count(x => x)
  }

  def isPalindrome(s: String): Boolean = {
    s.length == 1 || {
      val secondHalfEndIndex =
        if (s.length % 2 != 0)
          1 + s.length / 2
        else
          s.length / 2

      val halfs = (s.substring(0, s.length / 2), s.substring(secondHalfEndIndex))
      halfs._1 == halfs._2.reverse && halfs._1.distinct.length == 1
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = substrCount(n, s)

    println(result)
    printWriter.println(result)

    printWriter.close()
  }
}
