package kudadiri.dataengineer.sparkApp
package lib.transformation

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object FinalTransform {
  //  def printSimple(data: DataFrame): DataFrame = {
  //    val left = data.columns.take(2)
  //    val right = data.columns.takeRight(5)
  //    val concat = data.select(left.map(col) :+ lit("..").alias("..") :++ right.map(col): _*)
  //
  //    concat
  //  }

  def process(data: DataFrame): DataFrame = {
    val df = data
      .withColumn(
        "processingEndTime",
        ((current_timestamp().cast(DoubleType) * 1000).cast(LongType))
      )
      .withColumn(
        "processingEndTimeStr",
        current_timestamp().cast(TimestampType)
      )
      .withColumn(
        "end_to_end_latency",
        col("processingEndTime") - col("kafkaIngestTime")
      )

    df
  }
}
