package com.greenlabs.layoutdemo.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class AppCore {

    private static class AppCoreHolder {
        private static final AppCore INSTANCE = new AppCore();
    }

    public static AppCore getInstance(){return AppCoreHolder.INSTANCE;};

    public static Logger getLogger(Object o){
        return LoggerFactory.getLogger(o.getClass());
    }

}
