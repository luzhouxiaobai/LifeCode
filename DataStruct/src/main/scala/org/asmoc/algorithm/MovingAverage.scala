package org.asmoc.algorithm

import scala.collection.mutable

object MovingAverage {

  class Test(size: Int) {

    /** Initialize your data structure here. */
    val queue = new mutable.Queue[Int]()

    def next(`val`: Int): Double = {

      this.queue.enqueue(`val`)
      if (this.queue.size > this.size) {
        this.queue.dequeue()
      }

      if (this.queue.nonEmpty) {
        var sum = this.queue.sum.toDouble
        var nowSize = this.queue.size.toDouble
        sum / nowSize
      } else
        0

    }
  }

  def main(args: Array[String]): Unit = {
    val t = new Test(3)
    println(t.next(1))
    t.next(10)
    println(t.next(3))
    t.next(5)

  }
}
