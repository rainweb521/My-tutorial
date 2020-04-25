kafka配置参数



```
16:39:08.309 [main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = all
	batch.size = 16384
	bootstrap.servers = [192.168.3.2:9092]
	buffer.memory = 33554432
	client.id = 
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = [com.rain.chapter2.ProducerInterceptorPrefix]
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 1
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

16:39:08.431 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name bufferpool-wait-time
16:39:08.440 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name buffer-exhausted-records
16:39:08.445 [main] DEBUG org.apache.kafka.clients.Metadata - Updated cluster metadata version 1 to Cluster(id = null, nodes = [192.168.3.2:9092 (id: -1 rack: null)], partitions = [], controller = null)
16:39:08.453 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name produce-throttle-time
16:39:08.465 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name connections-closed:
16:39:08.466 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name connections-created:
16:39:08.466 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name successful-authentication:
16:39:08.467 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name failed-authentication:
16:39:08.470 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name bytes-sent-received:
16:39:08.471 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name bytes-sent:
16:39:08.472 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name bytes-received:
16:39:08.472 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name select-time:
16:39:08.473 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name io-time:
16:39:08.478 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name batch-size
16:39:08.479 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name compression-rate
16:39:08.479 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name queue-time
16:39:08.479 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name request-time
16:39:08.479 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name records-per-request
16:39:08.480 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name record-retries
16:39:08.480 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name errors
16:39:08.480 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name record-size
16:39:08.481 [main] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name batch-split-rate
16:39:08.482 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.producer.internals.Sender - [Producer clientId=producer-1] Starting Kafka producer I/O thread.
16:39:08.486 [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
16:39:08.486 [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
16:39:08.488 [main] DEBUG org.apache.kafka.clients.producer.KafkaProducer - [Producer clientId=producer-1] Kafka producer started
16:39:08.493 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initialize connection to node 192.168.3.2:9092 (id: -1 rack: null) for sending metadata request
16:39:08.493 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initiating connection to node 192.168.3.2:9092 (id: -1 rack: null)
16:39:08.577 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node--1.bytes-sent
16:39:08.578 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node--1.bytes-received
16:39:08.579 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node--1.latency
16:39:08.583 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.network.Selector - [Producer clientId=producer-1] Created socket with SO_RCVBUF = 310308, SO_SNDBUF = 146988, SO_TIMEOUT = 0 to node -1
16:39:08.715 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Completed connection to node -1. Fetching API versions.
16:39:08.715 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initiating API versions fetch from node -1.
16:39:08.737 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Recorded API versions for node -1: (Produce(0): 0 to 6 [usable: 6], Fetch(1): 0 to 8 [usable: 8], ListOffsets(2): 0 to 3 [usable: 3], Metadata(3): 0 to 6 [usable: 6], LeaderAndIsr(4): 0 to 1 [usable: 1], StopReplica(5): 0 [usable: 0], UpdateMetadata(6): 0 to 4 [usable: 4], ControlledShutdown(7): 0 to 1 [usable: 1], OffsetCommit(8): 0 to 4 [usable: 4], OffsetFetch(9): 0 to 4 [usable: 4], FindCoordinator(10): 0 to 2 [usable: 2], JoinGroup(11): 0 to 3 [usable: 3], Heartbeat(12): 0 to 2 [usable: 2], LeaveGroup(13): 0 to 2 [usable: 2], SyncGroup(14): 0 to 2 [usable: 2], DescribeGroups(15): 0 to 2 [usable: 2], ListGroups(16): 0 to 2 [usable: 2], SaslHandshake(17): 0 to 1 [usable: 1], ApiVersions(18): 0 to 2 [usable: 2], CreateTopics(19): 0 to 3 [usable: 3], DeleteTopics(20): 0 to 2 [usable: 2], DeleteRecords(21): 0 to 1 [usable: 1], InitProducerId(22): 0 to 1 [usable: 1], OffsetForLeaderEpoch(23): 0 to 1 [usable: 1], AddPartitionsToTxn(24): 0 to 1 [usable: 1], AddOffsetsToTxn(25): 0 to 1 [usable: 1], EndTxn(26): 0 to 1 [usable: 1], WriteTxnMarkers(27): 0 [usable: 0], TxnOffsetCommit(28): 0 to 1 [usable: 1], DescribeAcls(29): 0 to 1 [usable: 1], CreateAcls(30): 0 to 1 [usable: 1], DeleteAcls(31): 0 to 1 [usable: 1], DescribeConfigs(32): 0 to 2 [usable: 2], AlterConfigs(33): 0 to 1 [usable: 1], AlterReplicaLogDirs(34): 0 to 1 [usable: 1], DescribeLogDirs(35): 0 to 1 [usable: 1], SaslAuthenticate(36): 0 [usable: 0], CreatePartitions(37): 0 to 1 [usable: 1], CreateDelegationToken(38): 0 to 1 [usable: 1], RenewDelegationToken(39): 0 to 1 [usable: 1], ExpireDelegationToken(40): 0 to 1 [usable: 1], DescribeDelegationToken(41): 0 to 1 [usable: 1], DeleteGroups(42): 0 to 1 [usable: 1])
16:39:08.738 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Sending metadata request (type=MetadataRequest, topics=test) to node 192.168.3.2:9092 (id: -1 rack: null)
16:39:08.861 [kafka-producer-network-thread | producer-1] WARN org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Error while fetching metadata with correlation id 1 : {test=LEADER_NOT_AVAILABLE}
16:39:08.861 [kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - Cluster ID: 0ox3I_kpSNiHrkDjOP1Zsw
16:39:08.861 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.Metadata - Updated cluster metadata version 2 to Cluster(id = 0ox3I_kpSNiHrkDjOP1Zsw, nodes = [192.168.3.2:9092 (id: 1001 rack: null)], partitions = [], controller = 192.168.3.2:9092 (id: 1001 rack: null))
16:39:08.959 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initialize connection to node 192.168.3.2:9092 (id: 1001 rack: null) for sending metadata request
16:39:08.959 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initiating connection to node 192.168.3.2:9092 (id: 1001 rack: null)
16:39:08.959 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node-1001.bytes-sent
16:39:08.961 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node-1001.bytes-received
16:39:08.962 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name node-1001.latency
16:39:08.962 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.network.Selector - [Producer clientId=producer-1] Created socket with SO_RCVBUF = 310308, SO_SNDBUF = 146988, SO_TIMEOUT = 0 to node 1001
16:39:08.963 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Completed connection to node 1001. Fetching API versions.
16:39:08.963 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Initiating API versions fetch from node 1001.
16:39:08.967 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Recorded API versions for node 1001: (Produce(0): 0 to 6 [usable: 6], Fetch(1): 0 to 8 [usable: 8], ListOffsets(2): 0 to 3 [usable: 3], Metadata(3): 0 to 6 [usable: 6], LeaderAndIsr(4): 0 to 1 [usable: 1], StopReplica(5): 0 [usable: 0], UpdateMetadata(6): 0 to 4 [usable: 4], ControlledShutdown(7): 0 to 1 [usable: 1], OffsetCommit(8): 0 to 4 [usable: 4], OffsetFetch(9): 0 to 4 [usable: 4], FindCoordinator(10): 0 to 2 [usable: 2], JoinGroup(11): 0 to 3 [usable: 3], Heartbeat(12): 0 to 2 [usable: 2], LeaveGroup(13): 0 to 2 [usable: 2], SyncGroup(14): 0 to 2 [usable: 2], DescribeGroups(15): 0 to 2 [usable: 2], ListGroups(16): 0 to 2 [usable: 2], SaslHandshake(17): 0 to 1 [usable: 1], ApiVersions(18): 0 to 2 [usable: 2], CreateTopics(19): 0 to 3 [usable: 3], DeleteTopics(20): 0 to 2 [usable: 2], DeleteRecords(21): 0 to 1 [usable: 1], InitProducerId(22): 0 to 1 [usable: 1], OffsetForLeaderEpoch(23): 0 to 1 [usable: 1], AddPartitionsToTxn(24): 0 to 1 [usable: 1], AddOffsetsToTxn(25): 0 to 1 [usable: 1], EndTxn(26): 0 to 1 [usable: 1], WriteTxnMarkers(27): 0 [usable: 0], TxnOffsetCommit(28): 0 to 1 [usable: 1], DescribeAcls(29): 0 to 1 [usable: 1], CreateAcls(30): 0 to 1 [usable: 1], DeleteAcls(31): 0 to 1 [usable: 1], DescribeConfigs(32): 0 to 2 [usable: 2], AlterConfigs(33): 0 to 1 [usable: 1], AlterReplicaLogDirs(34): 0 to 1 [usable: 1], DescribeLogDirs(35): 0 to 1 [usable: 1], SaslAuthenticate(36): 0 [usable: 0], CreatePartitions(37): 0 to 1 [usable: 1], CreateDelegationToken(38): 0 to 1 [usable: 1], RenewDelegationToken(39): 0 to 1 [usable: 1], ExpireDelegationToken(40): 0 to 1 [usable: 1], DescribeDelegationToken(41): 0 to 1 [usable: 1], DeleteGroups(42): 0 to 1 [usable: 1])
16:39:08.967 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Sending metadata request (type=MetadataRequest, topics=test) to node 192.168.3.2:9092 (id: 1001 rack: null)
16:39:08.985 [kafka-producer-network-thread | producer-1] WARN org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Error while fetching metadata with correlation id 3 : {test=LEADER_NOT_AVAILABLE}
16:39:08.985 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.Metadata - Updated cluster metadata version 3 to Cluster(id = 0ox3I_kpSNiHrkDjOP1Zsw, nodes = [192.168.3.2:9092 (id: 1001 rack: null)], partitions = [], controller = 192.168.3.2:9092 (id: 1001 rack: null))
16:39:09.086 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Sending metadata request (type=MetadataRequest, topics=test) to node 192.168.3.2:9092 (id: 1001 rack: null)
16:39:09.145 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.clients.Metadata - Updated cluster metadata version 4 to Cluster(id = 0ox3I_kpSNiHrkDjOP1Zsw, nodes = [192.168.3.2:9092 (id: 1001 rack: null)], partitions = [Partition(topic = test, partition = 0, leader = 1001, replicas = [1001], isr = [1001], offlineReplicas = [])], controller = 192.168.3.2:9092 (id: 1001 rack: null))
16:39:09.181 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name topic.test.records-per-batch
16:39:09.184 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name topic.test.bytes
16:39:09.185 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name topic.test.compression-rate
16:39:09.186 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name topic.test.record-retries
16:39:09.187 [kafka-producer-network-thread | producer-1] DEBUG org.apache.kafka.common.metrics.Metrics - Added sensor with name topic.test.record-errors
```

