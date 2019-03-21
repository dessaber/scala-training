package com.levin.arraypermutations

import java.io._

object Solution {

  // Complete the permutationEquation function below.
  def permutationEquation(p: Array[Int]): Array[Int] = {
    val indicesToElems = p.indices.map(x => (p(x), x + 1)).toMap
    val result = p.indices.map(x => indicesToElems(indicesToElems(x + 1))).toArray
    result.foreach(println)
    result
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val p = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = permutationEquation(p)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}

