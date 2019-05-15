# hive 的安装

1. 下载hive
 1) 从官网下载: hive.apache.org
 2) 从cdh官网下载: http://archive.cloudera.com/cdh5/cdh/5/hive-1.1.0-cdh5.7.0.tar.gz
	
2. 解压HIVE
 tar -xzf tar -xzf hive-1.1.0-cdh5.7.0.tar.gz hive -C ~/app

3. 配置hive 环境变量
 vim ~/.bash_profile
  export HIVE_HOME=/home/hadoop/app/hive-1.1.0-cdh5.7.0
  export PATH=$HIVE_HOME/bin:$PATH
	
 source ~/.bash_profile

4. 启动hive
 命令: hive