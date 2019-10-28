package com.chenyj.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/28 22:33
 * 陈银杰专属测试
 */
public class MongoTest {

    @Test
    public  void  test01() {
        //连接mongo服务器
        MongoClient client=new MongoClient("192.168.1.103");
        //得到要操作的数据库
        MongoDatabase mongoDatabase=client.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit=mongoDatabase.getCollection("spit");
        //查询条件
        BasicDBObject bson=new BasicDBObject("visits",new BasicDBObject("$gt",1000));
        //得到所有的数据
        FindIterable<Document> documents = spit.find(bson);
        //遍历数据
        for (Document document:documents){
            System.out.println("用户id："+document.get("userid"));
            System.out.println("内容："+document.get("content"));
            System.out.println("浏览量："+document.get("visits"));
        }
        client.close();
    }

    @Test
    public  void  test02() {
        //连接mongo服务器
        MongoClient client=new MongoClient("192.168.1.103");
        //得到要操作的数据库
        MongoDatabase mongoDatabase=client.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit=mongoDatabase.getCollection("spit");
        Map<String, Object> map=new HashMap<>();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        Document document=new Document(map);
        spit.insertOne(document);
        client.close();
    }
}
