#!/bin/bash
# run-producers-with-logs.sh

JAR_FILE="KafkaProducerAlgorithm.jar"
BOOTSTRAP_SERVER="172.25.5.7:9092"
TOPIC="topic-network"
DATASET_PATH1="Dataset/skenario2_part1.csv"
DATASET_PATH2="Dataset/skenario2_part2.csv"
#DATASET_PATH3="Dataset/example_dataset_2_3.csv"
RATE=200

mkdir -p logs

echo "Starting 3 Kafka Producers..."
echo "Logs will be saved in logs/ directory"

# Producer 1
echo "Starting Producer-1..."
java -jar $JAR_FILE Producer-1 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH1 $RATE > logs/producer-1-app.log 2>&1 &
PID1=$!

# Producer 2
echo "Starting Producer-2..."
java -jar $JAR_FILE Producer-2 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH2 $RATE > logs/producer-2-app.log 2>&1 &
PID2=$!

## Producer 3
#echo "Starting Producer-3..."
#java -jar $JAR_FILE Producer-3 $BOOTSTRAP_SERVER $TOPIC $DATASET_PATH3 $RATE > logs/producer-3-app.log 2>&1 &
#PID3=$!

echo ""
echo "All producers started!"
echo "Producer-1 PID: $PID1"
echo "Producer-2 PID: $PID2"
#echo "Producer-3 PID: $PID3"
echo ""
echo "Analytics logs will be handled separately by logging config (logback/log4j)"
echo ""

trap "echo 'Stopping all producers...'; kill $PID1 $PID2; exit" INT
#trap "echo 'Stopping all producers...'; kill $PID1 $PID2 $PID3; exit" INT

wait