package com.example.neo4jdemo.utils;

import com.example.neo4jdemo.Entity.DatabaseEntity;
import org.neo4j.driver.Record;
public class EntityUtils {
    public static DatabaseEntity recordToDBEntity(Record record){
        DatabaseEntity databaseEntity=new DatabaseEntity();
        databaseEntity.setName(record.get("name").asString());
        databaseEntity.setAccess(record.get("access").asString());
        databaseEntity.setCurrentStatus(record.get("currentStatus").asString());
        return databaseEntity;

    }
}
