package com.greenlabs.layoutdemo.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.*;
import com.greenlabs.layoutdemo.web.client.view.HomeView;
import com.greenlabs.layoutdemo.web.client.view.View;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;


/**
 * Created by Ivan-TI on 9/15/2017
 **/
public class AppModule implements EntryPoint {

    private BorderLayoutContainer widget;
    private LayoutPanel northPanel;

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(View.loadView(new HomeView()));
    }


}
