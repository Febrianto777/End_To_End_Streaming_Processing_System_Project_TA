package kudadiri.dataengineer.sparkApp
package streamListener

import org.apache.spark.sql.SparkSession

import java.util.concurrent.{ConcurrentLinkedQueue, ScheduledExecutorService, Executors, TimeUnit}

class MetricsWriter(
                   spark: SparkSession,
                   queue: ConcurrentLinkedQueue[Metrics],
                   path: String
                   ) {

  private val scheduler: ScheduledExecutorService =
    Executors.newSingleThreadScheduledExecutor()

  def start(): Unit = {
    val task = new Runnable {
      override def run(): Unit = {
        flush()
      }
    }

    // Jalankan tiap 5 detik
    scheduler.scheduleAtFixedRate(
      task,
      0,
      5,
      TimeUnit.SECONDS
    )
  }

  def stop(): Unit = {
    println("[WRITER] Stopping scheduler...")
    scheduler.shutdown()

    try {
      if (!scheduler.awaitTermination(10, TimeUnit.SECONDS)) {
        scheduler.shutdownNow()
      }
    } catch {
      case _: InterruptedException => scheduler.shutdownNow()
    }

    flushRemaining()
  }

  private def flush(): Unit = {
    val batch = Iterator
      .continually(queue.poll())
      .takeWhile(_ != null)
      .toList

    if (batch.nonEmpty) {
      import spark.implicits._
      spark.createDataset(batch).write
        .mode("append")
        .parquet(path)
    }
    println(s"[WRITE] ${batch.size} records")
  }

  private def flushRemaining(): Unit = {
    println("[WRITER] Flushing remaining data...")
    flush()
  }
}