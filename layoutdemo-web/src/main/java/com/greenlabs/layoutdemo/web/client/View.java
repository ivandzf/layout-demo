package com.greenlabs.layoutdemo.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;


/**
 * Created by Ivan-TI on 9/15/2017
 **/
public class View implements IsWidget,EntryPoint {

    private final int MIN_HEIGHT = 480;
    private final int MIN_WIDTH = 720;

    private BorderLayoutContainer widget;

    @Override
    public void onModuleLoad() {
        Viewport viewport = new Viewport();
        viewport.add(this.asWidget());
        RootPanel.get().add(viewport);
    }

    @Override
    public Widget asWidget() {

        ContentPanel west = new ContentPanel();
        west.setHeadingText("Navigation");

        BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(200);
        westData.setMargins(new Margins(10, 10, 10 , 10));
        westData.setCollapsible(true);
        westData.setSplit(true);

        ContentPanel center = new ContentPanel();
        center.setHeadingText("EXAMPLE JAVA");

        MarginData centerData = new MarginData();
        centerData.setMargins(new Margins(10,10,10,0));

        widget = new BorderLayoutContainer();
        widget.setBorders(true);
        widget.setWestWidget(west, westData);
        widget.setCenterWidget(center, centerData);

        return widget;
    }
}
