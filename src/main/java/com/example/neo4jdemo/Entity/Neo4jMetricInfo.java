package com.example.neo4jdemo.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Neo4jMetricInfo {
    /***
     * 数据库列表
     */
    private List<DatabaseEntity> databaseList;

}
