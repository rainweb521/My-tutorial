# Zookeeper子节点介绍

zookeeper 中节点叫znode存储结构上跟文件系统类似，以树级结构进行存储。不同之外在于znode没有目录的概念，不能执行类似cd之类的命令。znode结构包含如下：

* **path**:唯一路径 
* **childNode**：子节点
* **stat**:状态属性
* **type**:节点类型

### 节点类型

| 类型                  | 描述                           |
| :-------------------- | :----------------------------- |
| PERSISTENT            | 持久节点                       |
| PERSISTENT_SEQUENTIAL | 持久序号节点                   |
| EPHEMERAL             | 临时节点(不可在拥有子节点)     |
| EPHEMERAL_SEQUENTIAL  | 临时序号节点(不可在拥有子节点) |

1. PERSISTENT（持久节点）

持久化保存的节点，也是默认创建的

```
#默认创建的就是持久节点
create /test
```

1. PERSISTENT_SEQUENTIAL(持久序号节点)

创建时zookeeper 会在路径上加上序号作为后缀，。非常适合用于分布式锁、分布式选举等场景。创建时添加 -s 参数即可。

```
#创建序号节点
create -s /test
#返回创建的实际路径
Created /test0000000001
create -s /test
#返回创建的实际路径2
Created /test0000000002
```

1. EPHEMERAL（临时节点）

临时节点会在客户端会话断开后自动删除。适用于心跳，服务发现等场景。创建时添加参数-e 即可。

```
#创建临时节点， 断开会话 在连接将会自动删除
create -e /temp
```

1. EPHEMERAL_SEQUENTIAL（临时序号节点）

与持久序号节点类似，不同之处在于EPHEMERAL_SEQUENTIAL是临时的会在会话断开后删除。创建时添加 -e -s 

```
create -e -s /temp/seq
```

### **节点属性**

```
# 查看节点属性
stat /qiurunze
```

其属性说明如下表：

```
#创建节点的事物ID
cZxid = 0x385

#创建时间
ctime = Tue Sep 24 17:26:28 CST 2019

#修改节点的事物ID
mZxid = 0x385

#最后修改时间
mtime = Tue Sep 24 17:26:28 CST 2019

# 子节点变更的事物ID
pZxid = 0x385

#这表示对此znode的子节点进行的更改次数（不包括子节点）
cversion = 0

# 数据版本，变更次数
dataVersion = 0

#权限版本，变更次数
aclVersion = 0

#临时节点所属会话ID
ephemeralOwner = 0x0

#数据长度
dataLength = 17

#子节点数(不包括子子节点)
numChildren = 0
```

### 节点的监听：

客户添加 -w 参数可实时监听节点与子节点的变化，并且实时收到通知。非常适用保障分布式情况下的数据一至性。其使用方式如下：

| 命令                 | 描述                                 |
| :------------------- | :----------------------------------- |
| ls -w path           | 监听子节点的变化（增，删）           |
| get -w path          | 监听节点数据的变化                   |
| stat -w path         | 监听节点属性的变化                   |
| printwatches on\|off | 触发监听后，是否打印监听事件(默认on) |


### 