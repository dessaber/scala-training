package com.levin.minimumdistances

import java.io._

import scala.annotation.tailrec
import scala.collection.Map

object Solution {

  // Complete the minimumDistances function below.
  def minimumDistances(numbers: Array[Int]): Int = {
    val lastPosOfNumber = Map[Int, Int]()
    val minDistanceOfNumber = Map[Int, Int]()

    minimumDistances(numbers, 0, lastPosOfNumber, minDistanceOfNumber, Int.MaxValue)
  }

  @tailrec
  private def minimumDistances(numbers: Array[Int], currentIndex: Int, lastPosOfNumber: Map[Int, Int],
                               minDistancesOfNumber: Map[Int, Int], totalMin: Int): Int = {
    if (numbers.isEmpty) {
      if (totalMin == Int.MaxValue)
        -1
      else
        totalMin
    } else {
      val existingPosition = lastPosOfNumber.getOrElse(numbers.head, currentIndex)
      val newMin = currentIndex - existingPosition
      val existingMin = minDistancesOfNumber.getOrElse(numbers.head, Int.MaxValue)
      val newTotalMin =
        if (totalMin > newMin && newMin != 0)
          newMin
        else
          totalMin

      val newDistances =
        if (newMin != 0 && existingMin > newMin) {
          minDistancesOfNumber + (numbers.head -> newTotalMin)
      } else {
          minDistancesOfNumber
      }

      minimumDistances(numbers.tail
        , currentIndex + 1
        , lastPosOfNumber + (numbers.head -> currentIndex)
        , newDistances
        , newTotalMin)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = minimumDistances(a)

    println(result)
    printWriter.println(result)

    printWriter.close()
  }
}
