package com.greenlabs.layoutdemo.core.common;

import java.io.Serializable;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class Result implements Serializable {

    public static final String SAVE_SUCCESS = "Data berhasil disimpan";
    public static final String SAVE_DATA_EXIST = "Data sudah ada";
    public static final String DELETE_SUCCESS = "Data berhasil dihapus";
    public static final String DB_EXCEPTION = "Database bermasalah";

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    private Long id;
    private String message;

    public Result(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Result(String message) {

        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
