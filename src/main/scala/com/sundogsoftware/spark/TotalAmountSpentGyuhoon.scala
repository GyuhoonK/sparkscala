package com.sundogsoftware.spark
import org.apache.spark._
import org.apache.log4j._

object TotalAmountSpentGyuhoon {
  def parseLine(line:String): (Int, Float) = {
    val fields = line.split(",")
    val field1 = fields(0).toInt
    val field2 = fields(2).toFloat

    (field1, field2)
  }

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "MaxTemperatures")
    val lines = sc.textFile("data/customer-orders.csv")
    val parsedLines = lines.map(parseLine)
    val totalAmountByID = parsedLines.reduceByKey( (x,y) => x+y)
    val idByTotal = totalAmountByID.map(x => (x._2, x._1)).sortByKey()
    val results = idByTotal.collect()

    // Print the results.
    results.foreach(println)
//    for (result <- totalAmountByID) {
//      val ID = result._1
//      val amount = result._2
//      println(s"$ID: $amount")
//    }
  }

}
