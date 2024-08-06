package com.mukesh.sample.etl
import org.apache.spark.sql.DataFrame

object PrintAwardJson {
  def printCleanDataset(flattenedDF: DataFrame): Unit = {
   //flattenedDF.show(false)
    flattenedDF.printSchema()
  }

}
