package com.greenlabs.layoutdemo.web.client.view.properties;

import com.google.gwt.editor.client.Editor;
import com.greenlabs.layoutdemo.core.entity.Mahasiswa;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

/**
 * Created by Ivan on 10/5/17
 */
public interface MahasiswaProperties extends PropertyAccess<Mahasiswa> {

    @Editor.Path("id")
    ModelKeyProvider<Mahasiswa> key();

    @Editor.Path("id")
    ValueProvider<Mahasiswa, Long> ID();

    @Editor.Path("NIM")
    ValueProvider<Mahasiswa, String> NIM();

    @Editor.Path("Nama")
    ValueProvider<Mahasiswa, String> Nama();

    @Editor.Path("Jurusan")
    ValueProvider<Mahasiswa, String> Jurusan();

}
