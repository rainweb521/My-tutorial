# 大数据生态环境安装
基础环境：
1. centos


## 安装过程
1. JDK安装
1.1 查看已经上传的jdk文件，并安装
安装命令： yum localinstall -y jdk-8u171-linux-x64.rpm
![](media/15577451060967.jpg)
添加到系统环境变量： ~/.bash_profile
       
```  
export JAVA_HOME=/usr/java/jdk1.8.0_171-amd64
export PATH=$JAVA_HOME/bin:$PATH:$HOME/bin
```
![](media/15577451919219.jpg)
![](media/15577451988821.jpg)

2. 安装Hadoop

下载并解压Hadoop，
已经下载并放到桌面上，直接解压，安装
解压：tar -zxvf Hadoop-2.6.0-cdh5.7.0.tar.gz
![](media/15577452782945.jpg)
查看目录，并进入/etc/Hadoop/
![](media/15577452364054.jpg)

5.   修改配置文件

hadoop配置文件的修改($HADDOP_HOME/etc/hadoop)
hadoop-env.sh

         export JAVA_HOME=/usr/java/jdk1.8.0_171-amd64
         
![](media/15577453252635.jpg)
         

```
 core-site.xml

         <property>

             <name>fs.defaultFS</name>

             <value>hdfs://localhost:9000</value>

         </property>

 

         由于hadoop伪分布式存储默认使用宿主系统的临时文件夹，会导致每次宿主系统重启后丢失，需要手动制定一个目录

         <property>

              <name>hadoop.tmp.dir</name>

              <value>/home/hadoop/app/tmp</value>

         </property>

 

     hdfs-site.xml

         <property>

            <name>dfs.replication</name>

             <value>1</value>

        </property>
```    
![](media/15577453824860.jpg)
![](media/15577453870522.jpg)
![](media/15577453932128.jpg)
给Hadoop配置环境变量

添加环境变量：

```
export HADOOP_HOME=/home/hadoop/app/hadoop-2.6.0-cdh5.7.0

export PATH=$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$PATH
```
![](media/15577454256483.jpg)
![](media/15577454303335.jpg)
使环境变量生效 source /etc/profile

查看Hadoop
![](media/15577454433670.jpg)
启动hdfs

格式化分布式文件系统（仅第一次执行即可，不可重复执行）：

     hdfs namenode -format
     ![](media/15577454666752.jpg)
启动: start-dfs.sh
![](media/15577454786854.jpg)
验证是否启动成功：

         jps

              NameNode

              SecondaryNameNode

              DataNode
            
![](media/15577454962672.jpg)
浏览器访问方式：http://localhost:50070
![](media/15577455184252.jpg)
8) 关闭hdfs

     stop-dfs.sh