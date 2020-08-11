package com.example.psipsi.retorofit.Pengaduan;

import java.util.List;

public class ResponseKecamatan {
    List<Kecamatan> kecamatan;

    public ResponseKecamatan(List<Kecamatan> name) {
        this.kecamatan = name;
    }

    public List<Kecamatan> getName() {
        return kecamatan;
    }

    public void setName(List<Kecamatan> name) {
        this.kecamatan = name;
    }
}
