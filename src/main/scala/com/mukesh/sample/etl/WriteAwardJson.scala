package com.mukesh.sample.etl

import org.apache.spark.sql.DataFrame


object WriteAwardJson {
  def writeAwardJson(data:DataFrame,filePath1: String): Unit = {
    data.write
      .format("csv")
      .option("header", "true")
      .mode("overwrite")
      .save(filePath1)
  }

}
