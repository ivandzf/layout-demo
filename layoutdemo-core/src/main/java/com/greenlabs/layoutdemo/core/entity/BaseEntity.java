package com.greenlabs.layoutdemo.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class BaseEntity implements Serializable{

    private Long id;
    private Date createdTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
