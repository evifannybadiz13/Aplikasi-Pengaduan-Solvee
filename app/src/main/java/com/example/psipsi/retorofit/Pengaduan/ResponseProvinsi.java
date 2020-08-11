package com.example.psipsi.retorofit.Pengaduan;

import java.util.List;

public class ResponseProvinsi {
    List<Provinsi> provinsi;

    public ResponseProvinsi(List<Provinsi> name) {
        this.provinsi = name;
    }

    public List<Provinsi> getName() {
        return provinsi;
    }

    public void setName(List<Provinsi> name) {
        this.provinsi = name;
    }
}
