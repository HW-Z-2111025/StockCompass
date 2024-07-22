package com

import org.apache.spark.{SparkConf, SparkContext}

object wash {
  def main(args Array[String]) Unit = {
    val sc = new SparkContext(new SparkConf().setMaster(local).setAppName(wash))
    sc.textFile(yuanshi.txt)
      .map(_.split(t))
      .filter(arr={
        arr.length == 8
      })
      .filter(arr={
        var openPrice = arr(1).toFloat
        var closePrice = arr(2).toFloat
        var lowestPrice = arr(3).toFloat
        var highestPrice = arr(4).toFloat
        var zhangfu = arr(5).toFloat
        var volume = arr(7).toLong
        openPrice0 && closePrice0 && lowestPrice0 && highestPrice0 && zhangfu0 && volume0
      })
      .map(arr={
        arr(0)+t+arr(1)+t+arr(2)+t+arr(3)+t+arr(4)+t+arr(5)+t+arr(6)+t+arr(7)
      })
      .repartition(1).saveAsTextFile(washResult)

  }
}
