package com.greenlabs.layoutdemo.web.client.view;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.greenlabs.layoutdemo.web.client.view.menu.dashboard.DashboardView;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.*;

/**
 * Created by Ivan-TI on 9/21/2017
 **/
public final class HomeView extends View {

    private BorderLayoutContainer widget;
    private TabPanel tabPanel;

    @Override
    public Widget asWidget() {

        LayoutPanel northPanel = new LayoutPanel();

        final Label title = new Label();
        //title.setStyleName("app-title-header");

        final HorizontalLayoutContainer hBoxLayoutContainer = new HorizontalLayoutContainer();
        hBoxLayoutContainer.setStyleName("demo-header");

        hBoxLayoutContainer.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                hBoxLayoutContainer.clear();
                hBoxLayoutContainer.add(title, new HorizontalLayoutContainer.HorizontalLayoutData(500,0));

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

        //widget.setNorthWidget(northPanel, new BorderLayoutContainer.BorderLayoutData(25));
        widget.setWestWidget(west, westData);
        widget.setCenterWidget(createPanel(), centerData);

        Viewport viewport = new Viewport();
        viewport.add(widget);
        return viewport;
    }

    public TabPanel createPanel(){
        tabPanel = new TabPanel();
        tabPanel.setBodyBorder(false);
        tabPanel.setBorders(false);
        tabPanel.setTabScroll(true);
        tabPanel.setCloseContextMenu(true);
        VerticalLayoutContainer container = new VerticalLayoutContainer();
        container.add(new DashboardView().asWidget(), new VerticalLayoutContainer.VerticalLayoutData(1,1));
        container.sync(true);
        tabPanel.add(container, new TabItemConfig("Dashboard",false));
        tabPanel.setActiveWidget(container);
        return tabPanel;
    }

}
