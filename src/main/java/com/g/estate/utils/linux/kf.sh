#! /bin/bash

case $1 in
"start")
	for i in k8s-master node1 node2
	do
		echo "============= 启动 $i kafka ============="
		ssh $i "/usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties"
	done
;;
"stop")
	for i in k8s-master node1 node2
	do
		echo "============= 停止 $i kafka ============="
		ssh $i "/usr/local/kafka/bin/kafka-server-stop.sh -daemon /usr/local/kafka/config/server.properties"
	done
;;
esac