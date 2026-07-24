package kudadiri.dataengineer.sparkApp
package lib.load

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.lit
import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}

import scala.collection.mutable

object ParquetSink {

  def writeBatc(df: DataFrame, config: mutable.HashMap[String, String], batchId: Long) = {
    val enrichedDf = df
      .withColumn("batch_id", lit(batchId))

    enrichedDf.write
      .format(config("format"))
      .option("path", config("target"))
      .mode(config("mode"))
      .save()
  }

  def process(data_final: DataFrame, config: mutable.HashMap[String, String]): StreamingQuery = {

//    val query = data_final.writeStream
//      .format("console")
//      .option("truncate", "false")
//      .outputMode("append")
//      .start()

    val query = data_final.writeStream
      .trigger(Trigger.ProcessingTime(config("triggerInterval")))
      .foreachBatch { (df: DataFrame, batchId: Long) =>
        writeBatc(df, config, batchId)
      }
      .option("checkpointLocation", config("checkpoint"))
      .start()

    query
  }
}
