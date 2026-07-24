#!/bin/bash
# run-sss.sh

spark-submit \
  --class kudadiri.dataengineer.sparkApp.SparkStructuredStreamingApp \
  --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.5.3 \
  SparkSide.jar
