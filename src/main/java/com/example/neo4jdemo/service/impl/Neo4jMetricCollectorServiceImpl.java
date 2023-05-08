package com.example.neo4jdemo.service.impl;

import com.example.neo4jdemo.Entity.DatabaseEntity;

import com.example.neo4jdemo.service.Neo4jMetricCollectorService;
import com.example.neo4jdemo.utils.EntityUtils;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Neo4jMetricCollectorServiceImpl implements Neo4jMetricCollectorService {

    @Autowired
    private Driver driver;
//
//    public MoviesService(Driver driver) {
//        this.driver = driver;
//    }

    /***
     * 列出所有的数据库
     * @return 每个数据库实体
     */
    @Override
    public List<DatabaseEntity> listDatabases() {
        try (Session session = driver.session()) {
            String cypherSql = "SHOW DATABASE";
            Result result = session.run(cypherSql);
            ArrayList<DatabaseEntity> databaseList = new ArrayList<>();
            while(result.hasNext()) {
                DatabaseEntity tmp=EntityUtils.recordToDBEntity(result.next());
                if(!tmp.getName().equals("system")){
                    databaseList.add(tmp);
                }

            }

            //获取各个数据库的实体个数
            //更详细的数据：db.stats.retrieve()
            for (DatabaseEntity databaseEntity :
                    databaseList) {
                cypherSql="use "+databaseEntity.getName()+" match(p) return count(*) as c";
                result = session.run(cypherSql);

                if(result.hasNext()) {
                    databaseEntity.setNodeCount(result.next().get("c").asLong());
                }
            }
            // 获取物理文件大小
            //apoc.metrics.storage()
            //cypherSql="sysinfo";
            //result = session.run(cypherSql);
            //List<Record> recordList=result.list();
//            if(result.hasNext()) {
//                System.out.println(result.next().get("c").asLong());
//            }
            return databaseList;
        }
    }
}
