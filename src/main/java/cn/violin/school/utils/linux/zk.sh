#!/bin/bash
params=$@

for i in k8s-master node1 node2
do
	echo "============= $i zk $params ============="
	ssh $i "/usr/local/zookeeper/bin/zkServer.sh $params"
done