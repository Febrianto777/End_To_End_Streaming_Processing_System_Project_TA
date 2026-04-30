package kudadiri.dataengineer.sparkApp

import kudadiri.dataengineer.sparkApp.utility.ConfigUtils._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.avro.functions.from_avro

import scala.io.Source
import org.apache.spark.sql.functions._

object SparTest {
  def main(args: Array[String]): Unit = {
    val config = getStreamConfigs("readStream")
    println(config)
  }
}
