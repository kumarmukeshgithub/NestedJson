package com.mukesh.sample.test

import com.mukesh.sample.etl.{ProcessAwardJson, ReadAwardJson}
import org.scalatest.funsuite.AnyFunSuite
import org.apache.spark.sql.{DataFrame, SparkSession}

class TestAwardJson extends AnyFunSuite {
  val spark: SparkSession = SparkSession.builder()
    .appName("JsonProcessorTest")
    .master("local[*]")
    .getOrCreate()
  val jsonFilePath: String ="/Users/mukeshbehera/Documents/json_award.json"

  test("Process Data Test") {
    val resultDF = ProcessAwardJson.transformData(ReadAwardJson.readDataset(spark,jsonFilePath))
    assert(resultDF.columns.length > 0)
    assert(resultDF.count() > 0)
  }
}
