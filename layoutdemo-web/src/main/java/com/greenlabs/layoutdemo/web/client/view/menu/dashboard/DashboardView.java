package com.greenlabs.layoutdemo.web.client.view.menu.dashboard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.greenlabs.layoutdemo.core.entity.Mahasiswa;
import com.greenlabs.layoutdemo.web.client.global.GlobalVar;
import com.greenlabs.layoutdemo.web.client.view.View;
import com.greenlabs.layoutdemo.web.client.view.properties.BaseProperties;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Format;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan-TI on 9/21/2017
 **/
public class DashboardView extends View {

    private FramedPanel widget;
    private FlowPanel flowPanel;
    private TextButton textButton;
    private TextButton textButton2;
    private ButtonBar buttonBar;
    private ListStore<Mahasiswa> store;
    private ColumnModel<Mahasiswa> cm;
    private Grid<Mahasiswa> gridMahasiswa;
    private ContentPanel root;
    private ContentPanel cpgrid;
    private GlobalVar GLOBAL_VARIABLE = GlobalVar.getInstance();
    private String IP_SERVICE_SPRING = GLOBAL_VARIABLE.IP_SERVICE_SPRING;

    @Override
    public Widget asWidget() {
        HBoxLayoutContainer hLayout = new HBoxLayoutContainer();

        VerticalLayoutContainer vUtama = new VerticalLayoutContainer();
        hLayout.add(vUtama, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 5, 0)));

        FramedPanel framedPanel = new FramedPanel();
        framedPanel.setHeight(50);
        framedPanel.setHeaderVisible(false);
        framedPanel.setBorders(false);
        vUtama.add(framedPanel);
        vUtama.setWidth("100%");

        HBoxLayoutContainer vToolBar = new HBoxLayoutContainer();
//        vToolBar.setHBoxLayoutAlign(HBoxLayoutContainer.HBoxLayoutAlign.STRETCH);

        textButton = new TextButton();
        textButton.setText("Tampilkan");
        textButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                createAler();
            }
        });

        textButton2 = new TextButton();
        textButton2.setText("INI DI TEKAN 2");
        flowPanel = new FlowPanel();

        BoxLayoutContainer.BoxLayoutData flex = new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0));
        flex.setFlex(1);

        vToolBar.add(new Label(), flex);
        vToolBar.add(textButton, new BoxLayoutContainer.BoxLayoutData(new Margins(5)));
        //vToolBar.add(textButton2, new BoxLayoutContainer.BoxLayoutData( new Margins(5)));

        framedPanel.add(vToolBar);

        VBoxLayoutContainer bro = new VBoxLayoutContainer();
        bro.setPadding(new Padding(0));
        bro.setVBoxLayoutAlign(VBoxLayoutContainer.VBoxLayoutAlign.STRETCH);

        cpgrid = dataGrid();
        bro.add(cpgrid, flex);

        VerticalLayoutContainer con = new VerticalLayoutContainer();
        con.add(hLayout, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        con.add(bro, new VerticalLayoutContainer.VerticalLayoutData(1, 1));

        widget = new FramedPanel();
        widget.setHeaderVisible(false);
        widget.setBodyBorder(false);
        widget.setBorders(false);
        widget.setWidget(con);

        return widget;
    }

    private void createAler() {
        loadMahasiswa("mahasiswa");
    }

    private DialogHideEvent.DialogHideHandler hideHandler = new DialogHideEvent.DialogHideHandler() {
        @Override
        public void onDialogHide(DialogHideEvent dialogHideEvent) {
            String message = Format.substitute("The '{0}' button was pressed ", dialogHideEvent.getHideButton());
            Info.display("MessageBox", message);
        }
    };

    private ContentPanel dataGrid() {

        store = new ListStore<Mahasiswa>(getProperties().getMahasiswaProperties().key());
        store.setEnableFilters(true);

        ColumnConfig<Mahasiswa, Long> Id = new ColumnConfig<Mahasiswa, Long>(getProperties().getMahasiswaProperties().ID(), 100, "ID");
        ColumnConfig<Mahasiswa, String> NIM = new ColumnConfig<Mahasiswa, String>(getProperties().getMahasiswaProperties().NIM(), 200, "NIM");
        ColumnConfig<Mahasiswa, String> Nama = new ColumnConfig<Mahasiswa, String>(getProperties().getMahasiswaProperties().Nama(), 300, "Nama");
        ColumnConfig<Mahasiswa, String> Jurusan = new ColumnConfig<Mahasiswa, String>(getProperties().getMahasiswaProperties().Jurusan(), 200, "Jurusan");

        List<ColumnConfig<Mahasiswa, ?>> l = new ArrayList<ColumnConfig<Mahasiswa, ?>>();

        l.add(Id);
        l.add(NIM);
        l.add(Nama);
        l.add(Jurusan);

        cm = new ColumnModel<Mahasiswa>(l);
        gridMahasiswa = new Grid<Mahasiswa>(store, cm);
        gridMahasiswa.setLoadMask(true);
        gridMahasiswa.setBorders(false);

        root = new ContentPanel();
        root.setHeaderVisible(false);

        VerticalLayoutContainer con = new VerticalLayoutContainer();

        con.add(gridMahasiswa);

        root.setWidget(con);

        return root;
    }

    private void loadMahasiswa(String param) {
        String url = IP_SERVICE_SPRING + param;
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        builder.setHeader("Content-Type", "application/json");
        builder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        builder.setCallback(new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {
                if (response.getStatusCode() == 200) {
                    List<Mahasiswa> listResult = new ArrayList<Mahasiswa>();
                    JSONValue value = JSONParser.parseStrict(response.getText());
                    JSONObject jsonObject;
                    JSONArray jsonArray;
                    jsonObject = value.isObject();
                    value = jsonObject.get("data");
                    jsonArray = value.isArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Mahasiswa listDetail = new Mahasiswa();
                        listDetail.setId(Long.parseLong(jsonArray.get(i).isObject().get("id").toString().replace("\"", "")));
                        listDetail.setNIM(jsonArray.get(i).isObject().get("nim").toString().replace("\"", ""));
                        listDetail.setNama(jsonArray.get(i).isObject().get("nama").toString().replace("\"", ""));
                        listDetail.setJurusan(jsonArray.get(i).isObject().get("jurusan").toString().replace("\"", ""));
                        listResult.add(listDetail);
                    }
                    store.clear();
                    store.addAll(listResult);
//                    gridMahasiswa.unmask();
                }
            }

            @Override
            public void onError(Request request, Throwable throwable) {

            }
        });

        try {
            builder.send();
        } catch (RequestException e) {
            e.printStackTrace();
        }

    }

}
