package kudadiri.dataengineer.sparkApp
package lib.load

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.streaming.StreamingQuery
import scala.collection.mutable

object ParquetSink {
  def process(data_final: DataFrame, config: mutable.HashMap[String, String]): StreamingQuery = {

//    val query = data_final.writeStream
//      .format("console")
//      .option("truncate", "false")
//      .outputMode("append")
//      .start()

        val query = data_final.writeStream
          .format(config("format"))
          .option("path", config("target"))
          .option("checkpointLocation", config("checkpoint"))
          .outputMode(config("mode"))
          .start()

    query
  }
}
