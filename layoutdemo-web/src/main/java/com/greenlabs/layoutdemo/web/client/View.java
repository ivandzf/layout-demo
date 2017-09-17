package com.greenlabs.layoutdemo.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;


/**
 * Created by Ivan-TI on 9/15/2017
 **/
public class View implements EntryPoint {

    @Override
    public void onModuleLoad() {
        TextButton btn = new TextButton("Hello World!!");
        RootPanel.get().add(btn);
        System.out.println("ini kebuka");
    }
}
