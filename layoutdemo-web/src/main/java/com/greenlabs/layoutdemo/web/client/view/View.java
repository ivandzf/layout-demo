package com.greenlabs.layoutdemo.web.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.greenlabs.layoutdemo.web.client.view.properties.BaseProperties;

/**
 * Created by Ivan-TI on 9/21/2017
 **/
public abstract class View implements IsWidget {

    public static Widget loadView(View view) {
        return view.asWidget();
    }

    @Override
    public Widget asWidget() {
        return asWidget();
    }

    protected BaseProperties getProperties(){
        return BaseProperties.getInstance();
    }

}
