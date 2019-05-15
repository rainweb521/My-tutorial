

## 安装过程
# 1. JDK安装
1.1 查看已经上传的jdk文件，并安装
安装命令： yum localinstall -y jdk-8u171-linux-x64.rpm
![](media/15577451060967.jpg)
1.2 添加到系统环境变量： ~/.bash_profile
       
```  
export JAVA_HOME=/usr/java/jdk1.8.0_171-amd64
export PATH=$JAVA_HOME/bin:$PATH:$HOME/bin
```
![](media/15577451919219.jpg)
![](media/15577451988821.jpg)
