package com.myspring.groupworker.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
public class User {

    public User(String name, Integer groupId){
        this.name = name;
        this.groupId = groupId;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "group_id")
    private Integer groupId;
}
