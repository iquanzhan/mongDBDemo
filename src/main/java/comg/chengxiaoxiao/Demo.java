package comg.chengxiaoxiao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BasicBSONObject;
import org.bson.Document;

/**
 * @ClassName: Demo
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-07
 */
public class Demo {


    public static void main(String[] args) {
        //基本查询
        //basicFind();
        //条件查询
        searchFind();


    }

    /**
     * 条件查询
     */
    private static void searchFind() {
        MongoClient client = new MongoClient("192.168.217.130");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //比较相等时，
        //BasicDBObject dbObject = new BasicDBObject("userid", "1011");
        //查询字段值大于1000的记录
        BasicDBObject dbObject = new BasicDBObject("userid", new BasicDBObject("$gt", 1000));


        FindIterable<Document> documents = spit.find(dbObject);

        for (Document doc : documents) {
            System.out.println("content=" + doc.getString("content"));
        }

        client.close();
    }

    /**
     * 基本查询
     */
    public static void basicFind() {
        MongoClient client = new MongoClient("192.168.217.130");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        FindIterable<Document> documents = spit.find();

        for (Document doc : documents) {
            System.out.println("content=" + doc.getString("content"));
        }

        client.close();
    }

}
