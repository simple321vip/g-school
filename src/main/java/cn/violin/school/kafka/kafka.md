### kafka mq
[kafka公式](https://kafka.apache.org/) <br />
[kafka教室](https://www.bilibili.com/video/BV1vr4y1677k?p=5&spm_id_from=pageDriver)<br />

#####消息队列的两种模式<br />
    - p2p　point to point 点对点模式<br />
        即消息被消费后，不在保存<br />
    - 发布订阅模式<br />
        消息会被保存，kafka默认保存7天，取消息用offset来进行。<br />

##### kafka基础架构
    - 为了方便扩展，提高吞吐量，1个topic分为多个partition
    - kafka的生产者，分为leader和follower，follower不参与生产，只负责备份副本
    - kafka还有一部分数据是存在zookeeper里面，记录kafka服务器状态，offset
    - 2.8以后可以没用配zookeeper，去zookeeper化。
    - kafka 有生产者，消费者，和broker,broker负责topic

##### kafka 安装
    - server.properties
        broker.id=0
        log.dirs=/var/log/kafka-logs
        zookeeper.connect=k8s-server:2181,node1:2181/kafka
