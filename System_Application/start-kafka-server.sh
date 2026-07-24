#!/bin/bash

# Path config Kafka
KAFKA_CONFIG="$KAFKA_CNF/kraft/server-plaintext.properties"

# Cek apakah sudah pernah format
if [ ! -f "/tmp/kraft-combined-logs/meta.properties" ]; then
  echo "Formatting storage..."
  
  CLUSTER_ID=$(kafka-storage.sh random-uuid)
  echo "Generated Cluster ID: $CLUSTER_ID"
  
  kafka-storage.sh format -t "$CLUSTER_ID" -c "$KAFKA_CONFIG"
else
  echo "Storage already formatted. Skipping..."
fi

# Start Kafka
echo "Starting Kafka..."
kafka-server-start.sh "$KAFKA_CONFIG"
