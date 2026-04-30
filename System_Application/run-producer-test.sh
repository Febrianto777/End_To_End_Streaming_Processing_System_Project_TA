#!/bin/bash
# run-producers-with-logs.sh

JAR_FILE="KafkaProducerAlgorithm.jar"
BOOTSTRAP_SERVER="172.25.5.7:9092"
TOPIC="records-example"
DATASET_PATH1="Dataset/example_dataset_2_1.csv"
DATASET_PATH2="Dataset/example_dataset_2_2.csv"
DATASET_PATH3="Dataset/example_dataset_2_3.csv"
RATE=200

# Buat direktori logs jika belum ada
mkdir -p logs

echo "Starting 3 Kafka Producers..."
echo "Logs will be saved in logs/ directory"

# Producer 1 - log ke file
echo "Starting Producer-1..."
java -jar $JAR_FILE Producer-1 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH1 $RATE > logs/producer-1.log 2>&1 &
PID1=$!

# Producer 2 - log ke file
echo "Starting Producer-2..."
java -jar $JAR_FILE Producer-2 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH2 $RATE > logs/producer-2.log 2>&1 &
PID2=$!

# Producer 3 - log ke file
echo "Starting Producer-3..."
java -jar $JAR_FILE Producer-3 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH3 $RATE > logs/producer-3.log 2>&1 &
PID3=$!

echo ""
echo "All producers started!"
echo "Producer-1 PID: $PID1 (logs: logs/producer-1.log)"
echo "Producer-2 PID: $PID2 (logs: logs/producer-2.log)"
echo "Producer-3 PID: $PID3 (logs: logs/producer-3.log)"
echo ""
echo "To monitor logs:"
echo "  tail -f logs/producer-1.log"
echo "  tail -f logs/producer-2.log"
echo "  tail -f logs/producer-3.log"
echo ""
echo "Press Ctrl+C to stop all producers..."

# Trap Ctrl+C untuk menghentikan semua producer
trap "echo 'Stopping all producers...'; kill $PID1 $PID2 $PID3; exit" INT

# Wait for all processes
wait