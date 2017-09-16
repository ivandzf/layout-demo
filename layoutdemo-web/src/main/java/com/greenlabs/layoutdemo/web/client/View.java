package com.greenlabs.layoutdemo.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Created by Ivan-TI on 9/15/2017
 **/
public class View implements EntryPoint {

    @Override
    public void onModuleLoad() {

        RootPanel.get().add(new Label("Hello World !!"));
    }
}
