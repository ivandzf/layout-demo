package com.greenlabs.layoutdemo.core;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class Profil {

    private String name;
    private String appTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public static enum STATUS {
        PROD, DEV
    }

}
