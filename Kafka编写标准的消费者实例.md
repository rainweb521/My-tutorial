## Kafka编写标准的消费者实例

基本的消费者只需要四个配置参数，这也是实现消费者的最小参数个数，其他配置参数则全部使用默认值。四个参数分别是：

1. broker地址：为了找到Kafka中broker，这里注意，集群节点和单机节点一样，可以只写一个地址，其他的元数据信息会在连接之后自动查找到的，不过还是尽量写全，不然某个节点挂掉就会彻底连不上。
2. group：消费者名称。
3. KEY_SERIALIZER，将key值反序列化的方法，需要和生产者的序列化方法对应起来。
4. VALUE_SERIALIZER，将value反序列化的方法，需要和生产者的序列化方法对应起来。

```
public class ConsumerDemo3 {
    public static void main(String[] args){
        Properties properties = new Properties();
        //配置borker地址，集群版本写一个地址即可
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "nas-cluster1:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer",StringDeserializer.class.getName());
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList("test.topic"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, value = %s,partition = %s", record.offset(), record.value(),record.partition());
                }
            }
        }finally {
            kafkaConsumer.close();
        }
    }
}
```