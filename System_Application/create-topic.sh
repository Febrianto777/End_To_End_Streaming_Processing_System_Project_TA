#/bin/bash
# create-topic.sh

kafka-topics.sh --create --topic topic-network --partitions 2 --bootstrap-server 172.25.5.7:9092
