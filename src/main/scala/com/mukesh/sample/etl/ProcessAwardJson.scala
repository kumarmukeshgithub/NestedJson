package com.mukesh.sample.etl


import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object ProcessAwardJson {
  def transformData(dataFrame: DataFrame): DataFrame = {

    val flattenedDF = dataFrame.select(
      col("awardYear"),
      col("category.en").as("category_en"),
      col("category.no").as("category_no"),
      col("category.se").as("category_se"),
      col("dateAwarded"),
      explode(col("laureates")).as("laureate")
    ).select(
      col("awardYear"),
      col("category_en"),
      col("category_no"),
      col("category_se"),
      col("dateAwarded"),
      col("laureate.id"),
      col("laureate.knownName.en").as("laureate_knownName_en"),
      //col("laureate.knownName.no").as("laureate_knownName_no"),
      col("laureate.links.href").as("laureate_links_href"),
      // col("laureate.motivation.en").as("laureate_motivation_en"),
      // col("laureate.orgName.en").as("laureate_orgName_en"),
      col("laureate.portion"),
      col("laureate.sortOrder")
    )
    flattenedDF
  }
}


