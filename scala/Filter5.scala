package com

import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{FloatType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

import java.util.Properties

object Filter5 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Filter5").setMaster("local"))
    val lineRDD = sc.textFile("/washResult")
    val mapRDD = lineRDD.map(line=>{
      (line.split("\t")(6), line)
    })
    val groupRDD = mapRDD.groupByKey()
    val filterRDD = groupRDD.filter(gpname_arr=>{
      var gpname = gpname_arr._1
      var arr = gpname_arr._2
      var yang_times = 0
      var yin_times = 0
      for(line <- arr){
        var zhangfu = line.split("\t")(5)
        if(zhangfu.toFloat>0){
          yang_times+=1
        }
        else {
          yin_times+=1
        }
      }
      //filter的条件：
      yang_times>yin_times
    })

    val resultRDD = filterRDD.flatMap(_._2).filter(line=>{
      var date = line.split("\t")(0).toInt
      //date>20220101
      true
    })

    val rowsRDD = resultRDD.map(line=>{
      var arr = line.split("\t")
      Row(arr(0), arr(1), arr(2), arr(3), arr(4), arr(5), arr(6), arr(7))
    })

    var schema = StructType(
      List(
        StructField("yyyymmdd",StringType),
        StructField("openprice",StringType),
        StructField("closeprice",StringType),
        StructField("lowprice",StringType),
        StructField("highprice",StringType),
        StructField("zhangfu",StringType),
        StructField("gpname",StringType),
        StructField("volume",StringType)
      )
    )
    val sqlContext = new SQLContext(sc)
    val df = sqlContext.createDataFrame(rowsRDD,schema)
    var prop = new Properties()
    prop.put("user","root")
    prop.put("password","123456")
    prop.put("driver","com.mysql.cj.jdbc.Driver")
    //df.write.mode("append").jdbc("jdbc:mysql://localhost:3306/test","emp",prop)  //追加
    df.write.jdbc("jdbc:mysql://localhost:3306/test","stock",prop)   //创建新表并写入数据
  }
}
