package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{FloatType, IntegerType, StringType, StructType}

/** Find the minimum temperature by weather station */
object TotalSpentDatasetGyuhoonK {

  case class Customer(customerID:Int, itemID:Int, amountSpent:Float)

  /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Create a SparkSession using every core of the local machine
    val spark = SparkSession
      .builder
      .appName("MinTemperatures")
      .master("local[*]")
      .getOrCreate()

    val customerSchema = new StructType() // sameType and same Name to case Class
      .add("customerID", IntegerType, nullable = true)
      .add("itemID", IntegerType, nullable = true)
      .add("amountSpent", FloatType, nullable = true)

    // Read the file as dataset
    import spark.implicits._
    val ds = spark.read
      .schema(customerSchema) // let Dataset know header -> more optimizaion
      .csv("data/customer-orders.csv")
      .as[Customer]
    
    val custormerSpent = ds.groupBy("customerID")
    .agg(round(sum("amountSpent"),2).as("sum_amount"))
    custormerSpent.show(custormerSpent.count.toInt)
    val customerSpentSorted = custormerSpent.sort("sum_amount")
    customerSpentSorted.show(customerSpentSorted.count.toInt)

  }

}