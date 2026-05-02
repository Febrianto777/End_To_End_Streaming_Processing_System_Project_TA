package kudadiri.dataengineer.sparkApp
package lib.transformation

import org.apache.spark.ml.classification.RandomForestClassificationModel
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object RandomForestPredictor {
  def process(data: DataFrame, rf_model: RandomForestClassificationModel): DataFrame = {
    val selectedColumns = Array(
      "Flow_ID",
      "Source_IP",
      "Source_Port",
      "Destination_IP",
      "Destination_Port",
      "producer_timestamp",
      "kafkaIngestTime",
      "producerTimestampStr",
      "kafkaIngestTimeStr",
      "Label",
      "prediction"
    )

    val df_predict = rf_model.transform(data)
    val df = df_predict.select(selectedColumns.map(col): _*)

    df
  }
}