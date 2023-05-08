package com.example.neo4jdemo.controller;

import com.example.neo4jdemo.Entity.DatabaseEntity;
import com.example.neo4jdemo.service.Neo4jMetricCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class Neo4jMetricCollectorController {
    @Autowired
    Neo4jMetricCollectorService neo4jMetricCollectorService;

    @RequestMapping("listDatabases")
    public List<DatabaseEntity> listDatabases() {
        return neo4jMetricCollectorService.listDatabases();
    }
}
