# 3.安装Zookeeper

将zookeeper解压到app目录中，

因为需要配置一个伪分布式环境，需要模拟3个节点，所以要配置3个配置文件：zoo1.cfg, zoo2.cfg, zoo3.cfg
复制3个内容一样的配置文件:

```
         mv zoo_sample.cfg zoo1.cfg

         cp zoo1.cfg zoo2.cfg

         cp zoo1.cfg zoo3.cfg
```
![](media/15578313003946.jpg)
![](media/15578313042115.jpg)
/root/app/zookeeper-3.4.5-cdh5.7.0/data/zk1

在zoo1.cfg中修改


```2. 分别配置 zoo1.cfg, zoo2.cfg, zoo3.cfg

         a) conf/zoo1.cfg

              修改: dataDir=/home/hadoop/app/zookeeper-3.4.5-cdh5.7.0/data/zk1

                     clientPort=2181

              新增:

                   server.1=127.0.0.1:2888:3888

                   server.2=127.0.0.1:2889:3889

                   server.3=127.0.0.1:2890:3890

                  

         b) conf/zoo2.cfg

              修改：dataDir=/home/hadoop/app/zookeeper-3.4.5-cdh5.7.0/data/zk2

                     clientPort=2182

              新增:

                   server.1=127.0.0.1:2888:3888

                   server.2=127.0.0.1:2889:3889

                   server.3=127.0.0.1:2890:3890

                  

         c) conf/zoo3.cfg

              修改：dataDir=/home/hadoop/app/zookeeper-3.4.5-cdh5.7.0/data/zk3

                     clientPort=2183

              新增:

                   server.1=127.0.0.1:2888:3888

                   server.2=127.0.0.1:2889:3889

                   server.3=127.0.0.1:2890:3890
```

![](media/15578313529977.jpg)
![](media/15578313601694.jpg)
![](media/15578313652390.jpg)
![](media/15578313726981.jpg)
创建zookeeper的文件存储目录
![](media/15578313880710.jpg)
创建节点标志
![](media/15578313972346.jpg)
启动zookeeper实例

./bin/zkServer.sh start conf/zoo3.cfg
![](media/15578314092422.jpg)
验证zookeeper是否启动成功

 ./bin/zkServer.sh status conf/zoo3.cfg
 ![](media/15578314207037.jpg)
多了三个QuorumPeerMain
![](media/15578314321408.jpg)
