package com

import org.apache.spark.{SparkConf, SparkContext}

object Aa {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local").setAppName("qingxi"))
    sc.textFile("D:/大二/实习实训/7.19/yuanshi.txt")
      .map(_.split("\t"))
      .filter(arr => {
        arr.length==8
      })
      .filter(arr => {
        var openPrice = arr(1).toFloat
        var closePrice = arr(2).toFloat
        var lowPrice = arr(3).toFloat
        var highPrice = arr(4).toFloat
        var zhangfu = arr(5).toFloat
        var volume = arr(7).toLong
        openPrice>0&&
          closePrice>0&&
          lowPrice>0&&
          highPrice>0&&
          //zhangfu>0&&
        volume>0
      })
      .map(arr => {
        arr(0)+"\t"+arr(1)+"\t"+arr(2)+"\t"+arr(3)+"\t"+arr(4)+"\t"+arr(5)+"\t"+arr(6)+"\t"+arr(7)
      })
      .repartition(1)
      .saveAsTextFile("D:/大二/实习实训/7.23/myclearresult")


  }

}
