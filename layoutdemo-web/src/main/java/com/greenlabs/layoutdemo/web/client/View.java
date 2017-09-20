package com.greenlabs.layoutdemo.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;


/**
 * Created by Ivan-TI on 9/15/2017
 **/
public class View implements IsWidget,EntryPoint {

    private BorderLayoutContainer widget;
    private LayoutPanel northPanel;

    @Override
    public void onModuleLoad() {

        Viewport viewport = new Viewport();
        viewport.add(this.asWidget());
        RootPanel.get().add(viewport);
    }

    @Override
    public Widget asWidget() {

        northPanel = new LayoutPanel();

        final Label title = new Label();
        title.setStyleName("app-title-header");

        final HorizontalLayoutContainer hBoxLayoutContainer = new HorizontalLayoutContainer();
        hBoxLayoutContainer.setStyleName("demo-header");

        hBoxLayoutContainer.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                hBoxLayoutContainer.clear();
                hBoxLayoutContainer.add(title, new HorizontalLayoutContainer.HorizontalLayoutData(200,0));

            }
        });

        hBoxLayoutContainer.setLayoutData(new HorizontalLayoutContainer.HorizontalLayoutData());

        northPanel.add(hBoxLayoutContainer);

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

        title.setText("Greenlabs Digital Signage [DEVELOPMENT]");

        widget = new BorderLayoutContainer();
        widget.setBorders(true);

        widget.setNorthWidget(northPanel, new BorderLayoutContainer.BorderLayoutData(38));
        widget.setWestWidget(west, westData);
        widget.setCenterWidget(center, centerData);

        return widget;
    }
}
