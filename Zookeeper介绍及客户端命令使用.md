# Zookeeper介绍及客户端命令使用

### 概要

Zookeeper是一个分布式数据一致性的解决方案，分布式应用可以基于它实现诸如数据发布/订阅，负载均衡，命名服务，分布式协调/通知，集群管理，Master选举，分布式锁和分布式队列等功能。Zookeeper致力于提供一个高性能、高可用、且具有严格的顺序访问控制能力的分布式协调系统。

### **作用**

    1.数据发布与订阅（配置中心）
    2.负载均衡
    3.命名服务(Naming Service)
    4.分布式通知/协调
    5.集群管理与Master选举
    6.分布式锁
    7.分布式队列

### 配置文件

```
# zookeeper时间配置中的基本单位 (毫秒)
tickTime=2000

# 允许follower初始化连接到leader最大时长，它表示tickTime时间倍数 即:initLimit*tickTime
initLimit=10

# 允许follower与leader数据同步最大时长,它表示tickTime时间倍数 
syncLimit=5

#zookeper 数据存储目录
dataDir=/tmp/zookeeper

#对客户端提供的端口号
clientPort=2181

#单个客户端与zookeeper最大并发连接数
maxClientCnxns=60

# 保存的数据快照数量，之外的将会被清除
autopurge.snapRetainCount=3

#自动触发清除任务时间间隔，小时为单位。默认为0，表示不自动清除。
autopurge.purgeInterval=1
```

### **客户端命令**

```
 1.close
 关闭当前会话
 
 2.connect host:port 
 重新连接指定Zookeeper服务
 
 create [-s] [-e] [-c] [-t ttl] path [data] [acl]
 3.创建节点
 
 delete [-v version] path
 删除节点，(不能存在子节点）
 
 4.deleteall path
 删除路径及所有子节点
 
 5.setquota -n|-b val path
设置节点限额 -n 子节点数 -b 字节数

 6.listquota path
查看节点限额

 7.delquota [-n|-b] path
 删除节点限额
 
 8.get [-s] [-w] path
 查看节点数据 -s 包含节点状态 -w 添加监听 
 getAcl [-s] path
 
 9.ls [-s] [-w] [-R] path
 列出子节点 -s状态 -R 递归查看所有子节点 -w 添加监听
 
 10.printwatches on|off**
 是否打印监听事件
 
 11.quit 
 退出客户端
 
 12.history 
 查看执行的历史记录
 
 13.redo cmdno
 重复 执行命令，history 中命令编号确定
 
 14.removewatches path [-c|-d|-a] [-l]
 删除指定监听
 
 15.set [-s] [-v version] path data
 设置值
 
 16.setAcl [-s] [-v version] [-R] path acl
 为节点设置ACL权限
 
 17.stat [-w] path
 查看节点状态 -w 添加监听
 
 18.sync path
  强制同步节点

```

 ### 四字运维命令

 ZooKeeper响应少量命令。每个命令由四个字母组成。可通过telnet或nc向ZooKeeper发出命令。
 这些命令默认是关闭的，需要配置4lw.commands.whitelist来打开，可打开部分或全部示例如下：

 ```
 #打开指定命令
 4lw.commands.whitelist=stat, ruok, conf, isro
 #打开全部
 4lw.commands.whitelist=*
 ```

 安装Netcat工具，已使用nc命令 

 ```
 #安装Netcat 工具
 yum install -y nc
 #查看服务器及客户端连接状态
 echo stat | nc localhost 2181
 ```

 **命令列表**

     1. conf：3.3.0中的新增功能：打印有关服务配置的详细信息。
     2. 缺点：3.3.0中的新增功能：列出了连接到该服务器的所有客户端的完整连接/会话详细信息。包括有关已接收/已发送的数据包数量，会话ID，操作等待时间，最后执行的操作等信息。
     3. crst：3.3.0中的新增功能：重置所有连接的连接/会话统计信息。
     4. dump：列出未完成的会话和临时节点。这仅适用于领导者。
     5. envi：打印有关服务环境的详细信息
     6. ruok：测试服务器是否以非错误状态运行。如果服务器正在运行，它将以imok响应。否则，它将完全不响应。响应“ imok”不一定表示服务器已加入仲裁，只是服务器进程处于活动状态并绑定到指定的客户端端口。使用“ stat”获取有关状态仲裁和客户端连接信息的详细信息。
     7. srst：重置服务器统计信息。
     8. srvr：3.3.0中的新功能：列出服务器的完整详细信息。
     9. stat：列出服务器和连接的客户端的简要详细信息。
     10. wchs：3.3.0中的新增功能：列出有关服务器监视的简要信息。
     11. wchc：3.3.0中的新增功能：按会话列出有关服务器监视的详细信息。这将输出具有相关监视（路径）的会话（连接）列表。请注意，根据手表的数量，此操作可能会很昂贵（即影响服务器性能），请小心使用。
     12. dirs：3.5.1中的新增功能：以字节为单位显示快照和日志文件的总大小
     13. wchp：3.3.0中的新增功能：按路径列出有关服务器监视的详细信息。这将输出具有关联会话的路径（znode）列表。请注意，根据手表的数量，此操作可能会很昂贵（即影响服务器性能），请小心使用。
     14. mntr：3.4.0中的新增功能：输出可用于监视集群运行状况的变量列表。

