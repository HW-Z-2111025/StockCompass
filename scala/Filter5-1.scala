package com

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

import java.util.Properties

object Filter5 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local").setAppName("阳线大于阴线"))
    val sqlContext = new SQLContext(sc)
    val lineRDD = sc.textFile("D:/大二/实习实训/7.23/myclearresult")
    val mapRDD = lineRDD.map(line => {
      (line.split("\t")(6),line)
    })
    val groupRDD = mapRDD.groupByKey()
    val filterRDD =  groupRDD.filter(gpname_arr => {

      var gpName = gpname_arr._1
      var arr = gpname_arr._2

      var yangTimes = 0
      var yinTimes = 0
      for (line <- arr) {
        var zhangfu = line.split("\t")(5).toFloat
        if(zhangfu>0){
          yangTimes +=1
        }else{
          yinTimes +=1
        }
      }
      yangTimes>yinTimes
    })

    var resultRDD = filterRDD.flatMap(_._2)

    //resultRDD.foreach(println)
    val rowsRDD =  resultRDD.map(lines => {
      var arr = lines.split("\t")
      Row(arr(0),arr(1),arr(2),arr(3),arr(4),arr(5),arr(6),arr(7))
    })
    //resultRDD  转成 dataframe
    var  schema =  StructType(
      List(
        StructField("yyyymmdd",StringType),
        StructField("openrice",StringType),
        StructField("closePrice",StringType),
        StructField("lowPrice",StringType),
        StructField("hiPrice",StringType),
        StructField("zhangfu",StringType),
        StructField("gpName",StringType),
        StructField("volume",StringType)
      )
    )
    val df = sqlContext.createDataFrame(rowsRDD,schema)
    var prop = new Properties()
    prop.put("user","root")
    prop.put("password","429616")
    prop.put("driver","com.mysql.cj.jdbc.Driver")
    //df.write.mode("append").jdbc("jdbc:mysql://localhost:3306/test","emp",prop)  //追加
    df.write.jdbc("jdbc:mysql://localhost:3306/test","table_stock",prop)   //创建新表并写入数据

  }

}
