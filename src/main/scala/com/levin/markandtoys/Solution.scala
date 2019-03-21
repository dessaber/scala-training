package com.levin.markandtoys

import java.io._

object Solution {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {
    val totalMoney = Array[Int](k)
    prices.sorted.takeWhile(x => {
      val currentMoney = totalMoney(0)
      totalMoney.update(0, currentMoney - x)
      totalMoney(0) > 0
    }).length
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    println(result)
    printWriter.println(result)

    printWriter.close()
  }
}

