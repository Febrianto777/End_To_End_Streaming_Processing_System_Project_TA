package kudadiri.dataengineer.sparkApp
package streamListener

import java.util.concurrent.ConcurrentLinkedQueue
import org.apache.spark.sql.streaming._

class MyStreamListener(queue: ConcurrentLinkedQueue[Metrics]) extends StreamingQueryListener {
  override def onQueryStarted(event: StreamingQueryListener.QueryStartedEvent): Unit = {
    println(s"[START] Query Started: ${event.id}")
  }

  override def onQueryProgress(event: StreamingQueryListener.QueryProgressEvent): Unit = {
    val p = event.progress
    val batchDuration = p.durationMs.getOrDefault("triggerExecution", 0L)
    val addBatchTime = p.durationMs.getOrDefault("addBatch", 0L)

    val throughput =
      if (addBatchTime > 0) {
        p.numInputRows / (addBatchTime / 1000.0)
      }
      else 0.0

    val metrics = Metrics(
      p.batchId,
      System.currentTimeMillis(),
      p.numInputRows,
      p.inputRowsPerSecond,
      p.processedRowsPerSecond,
      batchDuration,
      addBatchTime,
      throughput
    )

    try {
      queue.add(metrics)
    } catch {
      case e: Exception => println(s"[ERROR] Failed to enqueue metrics: ${e.getMessage}")
    }
  }

  override def onQueryTerminated(event: StreamingQueryListener.QueryTerminatedEvent): Unit = {
    println(s"[STOP] Query terminated: ${event.id}")
  }
}