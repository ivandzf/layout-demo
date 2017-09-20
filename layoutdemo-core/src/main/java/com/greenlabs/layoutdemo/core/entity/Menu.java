package com.greenlabs.layoutdemo.core.entity;

import java.io.Serializable;

/**
 * Created by Ivan-TI on 9/19/2017
 **/
public class Menu implements Serializable {

    private Long id;
    private String nama;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
