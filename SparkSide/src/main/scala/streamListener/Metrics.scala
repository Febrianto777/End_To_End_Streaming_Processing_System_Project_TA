package kudadiri.dataengineer.sparkApp
package streamListener

case class Metrics(
                  batchId: Long,
                  timestamp: Long,
                  numInputRows: Long,
                  inputRate: Double,
                  processRate: Double,
                  processingTimeMs: Long,
                  throughput: Double
                  )