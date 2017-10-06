package com.greenlabs.layoutdemo.core.entity;

import java.io.Serializable;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class Mahasiswa extends BaseEntity implements Serializable{

    private String NIM;
    private String Nama;
    private String Jurusan;

    public String getNIM() {
        return NIM;
    }

    public Mahasiswa() {
    }

    @Override

    public String toString() {
        final StringBuilder sb = new StringBuilder("Mahasiswa{");
        sb.append("ID='").append(getId()).append('\'');
        sb.append(", NIM='").append(NIM).append('\'');
        sb.append(", Nama='").append(Nama).append('\'');
        sb.append(", Jurusan='").append(Jurusan).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setJurusan(String jurusan) {
        Jurusan = jurusan;
    }
}
