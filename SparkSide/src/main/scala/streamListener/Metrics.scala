package kudadiri.dataengineer.sparkApp
package streamListener

case class Metrics(
                  batchId: Long,
                  timestamp: Long,
                  numInputRows: Long,
                  inputRate: Double,
                  processRate: Double,
                  batchDurationMs: Long,
                  addBatchTimeMs: Long,
                  throughput: Double
                  )