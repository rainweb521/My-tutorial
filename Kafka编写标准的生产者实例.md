# 编写标准的生产者实例

### 以前是有编写过简单的生产者代码，其实也是拷贝网上的代码，没有自己的想法和改进，代码很简单，而我更简单，这次说是标准的，就是参照官方代码，用很简单实际的代码去实现，不会随便粘贴一堆。

代码量不多，也没有出现一堆魔术变量名称。全用源码中ProducerConfig的值来调用，保证代码准确性。

在properties中只有三个参数，这也是实现生产者的最小参数个数，其他配置参数则全部使用默认值。三个参数分别是：

1. broker地址：为了找到Kafka中broker，这里注意，集群节点和单机节点一样，可以只写一个地址，其他的元数据信息会在连接之后自动查找到的，不过还是尽量写全，不然某个节点挂掉就会彻底连不上。
2. KEY_SERIALIZER，将key值序列化的方法，平时只关注消息内容，很少关注到原来还有key的区分。key在分区和日志压缩中会用到。
3. VALUE_SERIALIZER，将value序列化的方法，也就是我们传入的值。

有了这三个就可以发送消息，下面使用IntStream流，在发送时防止太快了不好观察，每发一次停顿2s，最后在finally中关闭producer。

```
public class ProducerDemo2 {
    public static void main(String[] args){
        Properties properties = new Properties();
        String brokerList = "192.168.3.1:9200";
        String topic = "test.topic";
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        Producer<String, String> producer =  new KafkaProducer<>(properties);
        try {
            IntStream.range(1,10).forEach(line->{
                String msg = line + "------Message ";
                producer.send(new ProducerRecord<>(topic, msg));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sent:" + msg);
            });
        }finally {
            producer.close();
        }
    }
}
```

