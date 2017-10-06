package com.greenlabs.layoutdemo.web.client.view.properties;

import com.google.gwt.core.client.GWT;

/**
 * Created by Ivan on 10/5/17
 */
public class BaseProperties {

    private static BaseProperties instance;
    private final MahasiswaProperties mahasiswaProperties = GWT.create(MahasiswaProperties.class);

    public BaseProperties() {
    }

    public MahasiswaProperties getMahasiswaProperties() {
        return mahasiswaProperties;
    }

    public static BaseProperties getInstance() {
        if (instance == null) {
            instance = new BaseProperties();
        }
        return instance;

    }

}
