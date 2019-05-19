package com.rain.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSUtil {

    FileSystem fs = null;

    @Before
    public void init() throws Exception {
//        读取配置文件
        Configuration conf = new Configuration();
//        手动设置路径
        conf.set("fs.defaultFS","hdfs://hmaster:9000/");
//        根据配置信息，去获取一个文件系统的操作对象
        fs = FileSystem.get(new URI("hdfs://hmaster:9000/"),conf,"hadoop");
    }

    @Test
    public void upload() throws IOException {
//        第一个是本地文件的路径，第二个是要上传到hdfs中的路径，必须保证本地文件是存在的，hdfs中不能有同名的文件
        fs.copyFromLocalFile(new Path("/Users/rain/Downloads/test/sample.txt"),
                new Path("hdfs://hmaster:9000/data/test1.txt"));
    }
    @Test
    public void mkdir() throws IOException {
        fs.mkdirs(new Path("/data/test1"));
    }

    @Test
    public void rm() throws IOException {
        fs.delete(new Path("/data/test1"));
    }

    @Test
    public void listFiles() throws IOException {
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path("/data"), true);
        while(files.hasNext()){
            LocatedFileStatus file = files.next();
            Path filePath = file.getPath();
            String filename = filePath.getName();
            System.out.println(filename);
        }
    }

}
