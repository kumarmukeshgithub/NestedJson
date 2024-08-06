package com.mukesh.sample.mains

import com.mukesh.sample.etl.{PrintAwardJson, ProcessAwardJson, ReadAwardJson, WriteAwardJson}
import org.apache.spark.sql.SparkSession


object MainProgram {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("ETL with Spark")
      .master("local[*]")
      .getOrCreate()
    try {

      if (args.length < 1) {
        throw new IllegalArgumentException("Please provide the path to the dataset CSV file as the first argument.")
      }
/*
The first argument contain path of the dataset.
The Path should be Given at run time.
*/
      val filePathForDataSet = args(0)
      /*
      The Second argument contain the path where
      want to write the final output.
       */
      val filePathForWriteFile= args(1)
      val rawDataset = ReadAwardJson.readDataset(spark,filePathForDataSet)
      val processedDataset = ProcessAwardJson.transformData(rawDataset)

      PrintAwardJson.printCleanDataset(processedDataset)
      WriteAwardJson.writeAwardJson(processedDataset,filePathForWriteFile)
    }
      finally{
        spark.stop()
      }
  }
}


