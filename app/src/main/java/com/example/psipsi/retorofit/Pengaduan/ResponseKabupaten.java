package com.example.psipsi.retorofit.Pengaduan;

import java.util.List;

public class ResponseKabupaten {
    List<Kabupaten> kabupaten;

    public ResponseKabupaten(List<Kabupaten> name) {
        this.kabupaten = name;
    }

    public List<Kabupaten> getName() {
        return kabupaten;
    }

    public void setName(List<Kabupaten> name) {
        this.kabupaten = name;
    }
}
