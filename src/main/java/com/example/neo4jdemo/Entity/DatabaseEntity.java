package com.example.neo4jdemo.Entity;

import lombok.Data;

import java.util.List;


@Data
public class DatabaseEntity {
    /***
     * 数据库名称
     */
    private String name;
    private String type;
    private List<String> aliases;
    private String access;
    private String address;
    private String role;
    private Boolean writer;
    private String requestedStatus;
    private String currentStatus;
    private String statusMessage;
    private Boolean  Default;
    private Boolean home;
    private List<String> constituents;
    /***
     * 节点个数
     */
    private Long nodeCount;
    /***
     * 数据大小
     */
    private Long dataSize;
}
