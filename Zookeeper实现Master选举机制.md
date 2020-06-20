# Zookeeper实现Master选举机制

解决思路：

假设不同的服务去注册同一个节点，节点数据为对应服务的ID，如果注册失败，就监听当前节点，当节点出现修改或删除时，再去修改为自己的ID，注册为master后不再进行监听，在监听时防止出现羊群效应，所有等待节点都在监听节点，一但节点变更所有等待节点都会被触发，如果等待对列过大会使用Zookeeper承受非常大的流量压力，所以设置一个随机休眠时间，让服务之间错峰竞争。

#### 示例使用curator框架来实现

引入依赖

```
 <dependencies>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.11</version>
        </dependency>

        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>2.12.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <version>2.12.0</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.22</version>
        </dependency>
    </dependencies>
```



```
/**
 * @Author: 
 * @Date: 2020/6/19
 * 实现分布式选举
 * 思路，通过注册临时顺序节点来判断当前节点是否为master
 * 如果不是master，就监听已经是master节点的
 * 设置随机请求时间，防止大面积发送监听信息
 */
public class MasterResolve {
    //配置基础参数
    private final String application = "111";
    private final String url = "127.0.0.1:2181";
    private CuratorFramework client;
    private static final String rootPath = "/qurotar-master";
    private static final String servicePath = rootPath + "/service";

    private Boolean master;

    /**
     * 在构造函数中初始化连接
     */
    public MasterResolve(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder().connectString(url).sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000).retryPolicy(retryPolicy).namespace("").build();
        client.start();
        //开始进行选举及监听
        initListener(CreateMode.EPHEMERAL);
    }

    /**
     * 创建节点
     * @param ephemeral 节点类型，持久化，顺序持久化，临时，顺序临时
     */
    private void initListener(CreateMode ephemeral) {
        try {
            client.create().creatingParentContainersIfNeeded().withMode(ephemeral).forPath(servicePath,application.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
        // 进行选举监听
        doElection();
    }

    /**
     * 对节点信息进行监听和修改
     */
    private void doElection() {

        try {
            //获取当前节点的数据，判断是否为自己
            String data = new String(client.getData().forPath(servicePath));
            if (!application.equals(data)){
                //设置随机休眠时间
                Thread.sleep(RandomUtil.randomInt(1000,3000));
                //获取节点信息
                Stat stat = client.checkExists().forPath(servicePath);
                if (stat!=null){
                    //设置监听器
                    client.getData().usingWatcher(new Watcher() {
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            System.out.println(watchedEvent.getType());
                            switch (watchedEvent.getType()) {
                                //当节点被删除时，创建自己的节点数据
                                case NodeDeleted:
                                    System.out.println("NODE_REMOVED : ");
                                    try {
                                        client.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(servicePath,application.getBytes());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    doElection();
                                    break;
                                 //当节点被修改时，去更新自己的数据
                                case NodeDataChanged:
                                    System.out.println("NODE_UPDATED : ");
                                    try {
                                        client.setData().forPath(servicePath,application.getBytes());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    doElection();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }).forPath(servicePath);
                }else{
                    master = false;
                }
            }else {
                master = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 判断当前是否为master
     * @return
     */
    public boolean isMaster() {
        return master;
    }

    /**
     * 最后关闭的时候关闭client
     */
    @PreDestroy
    public void destroy(){
        client.close();
    }

    public static void main(String[] args) throws InterruptedException {
        MasterResolve master = new MasterResolve();
        Thread.sleep(Long.MAX_VALUE);

    }
}

```

