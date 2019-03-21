package com.levin.greedyflorist

import java.io._

object Solution {

  // Complete the getMinimumCost function below.
  def getMinimumCost(k: Int, c: Array[Int]): Int = {
    val s = c.sorted
    c.indices.map(x => (x, 1 + x / k)).map(x => s(s.length - x._1 - 1) * x._2).sum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
    printWriter.println(minimumCost)

    printWriter.close()
  }
}
