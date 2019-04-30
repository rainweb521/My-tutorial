 所需要的软件及版本：
1. python2.7
2. pycharm
3. Django version 1.11.20
4. mysql5.7
## 需要先在电脑上安装python2.7，然后使用pip工具安装django，或者在pycharm中新建一个django项目将本项目的代码导入。
## 导入代码后在settings.py中修改你的数据库用户名和密码，再按照下面的文章链接，一步一步的将数据库生成（这里要注意的是，代码包中并不包含sql文件，django的数据库需要你自己使用项目中配置好的model来生成）
[Django链接MySQL数据库](https://www.cnblogs.com/testway/p/7435328.html)

## 在整个搭建完成后，通过pycharm或者命令行可以启动项目，访问地址是http://127.0.0.1:8000/