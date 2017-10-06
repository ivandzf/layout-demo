package com.greenlabs.layoutdemo.web.client.global;

/**
 * Created by Ivan on 10/5/17
 */
public class GlobalVar {

    private static GlobalVar instance;
    public String IP_SERVICE_SPRING = "http://localhost:8084/layoutdemo-ws/";

    public GlobalVar() {
    }

    public static synchronized GlobalVar getInstance() {
        if (instance == null) {
            instance = new GlobalVar();
        }
        return instance;
    }
}
