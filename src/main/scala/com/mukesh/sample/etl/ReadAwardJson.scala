package com.mukesh.sample.etl

import com.mukesh.sample.schema.NobelPrizeFlattened
import org.apache.spark.sql.{DataFrame, Encoders, SparkSession}
import com.mukesh.sample.schema
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.StructType


object ReadAwardJson {
  val schema1 = Encoders.product[NobelPrizeFlattened].schema
  def readDataset(spark: SparkSession,filePath: String): DataFrame = {
    spark.read
      .option("header", "true")
      .schema(schema1)
      .json(filePath)
  }
}