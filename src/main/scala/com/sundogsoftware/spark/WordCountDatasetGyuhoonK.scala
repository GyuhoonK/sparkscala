package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/** Count up how many of each word occurs in a book, using regular expressions. */
object WordCountDatasetGyuhoonK {
  case class Book(value : String)
  /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("WordCountDatasetGyuhoonK")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", "file:///C:/temp") // Necessary to work around a Windows bug in Spark 2.0.0; omit if you're not on Windows.
      .getOrCreate()
    import spark.implicits._

    val input = spark.read.text("data/book.txt").as[Book]

    val words = input
      .select(explode(split($"value", "\\W+")).alias("word"))
      .filter($"word"=!="") // $이 뭐더라 .. ??

    val lowercaseWords = words.select(lower($"word").alias("word"))

    val wordCounts = lowercaseWords.groupBy("word").count()
    val wordCountsSorted = wordCounts.sort("count")
    wordCountsSorted.show(wordCountsSorted.count.toInt) // 전체 행 표시
  }
  
}

