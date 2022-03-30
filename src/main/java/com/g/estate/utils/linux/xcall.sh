#! /bin/bash
params=$@

echo ============= k8s-master $params =============
ssh k8s-master "$params"

i=1
for (( i=1 ; i <= 2 ; i = $i + 1 )) ; do
    echo ============= node$i $params =============
    ssh node$i "$params"
done
