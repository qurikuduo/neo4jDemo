package com.example.neo4jdemo.service;

import com.example.neo4jdemo.Entity.DatabaseEntity;

import java.util.List;

public interface Neo4jMetricCollectorService {

    /***
     * 列出所有的数据库
     * @return 每个数据库实体
     */
    List<DatabaseEntity> listDatabases();

}
