package com.daniu101.model;

import java.util.Date;

/*
* 和Excel中的字段对应
*
* 和数据库中的字段对应
*
* 备注:Excel和数据库不对应时，对象的字段拷贝
* */
public class Person {

    private String id;
    private  String name;
    private String  work;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
