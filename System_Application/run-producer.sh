#!/bin/bash
# run-producers.sh

JAR_FILE="KafkaSide.jar"
PRODUCER_ID="Producer-1"
BOOTSTRAP_SERVER="172.25.5.7:9092"
TOPIC="topic-network"
DATASET_PATH1="Dataset/simulasi_pipeline_streaming.csv"
RATE=100

mkdir -p logs

echo "Starting with id: ${PRODUCER_ID}..."

$JAVA_HOME/bin/java -jar "$JAR_FILE" \
  "$PRODUCER_ID" \
  "$BOOTSTRAP_SERVER" \
  "$TOPIC" \
  "$DATASET_PATH1" \
  "$RATE"
