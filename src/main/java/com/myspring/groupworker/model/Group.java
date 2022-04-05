package com.myspring.groupworker.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "groups")
public class Group {
    public Group(String name){
        this.name = name;
    }

    @Column
    private String name;
}
