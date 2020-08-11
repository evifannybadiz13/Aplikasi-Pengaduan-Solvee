package com.example.psipsi.retorofit.Pengaduan;

import java.util.List;

public class ResponseDesa {
    List<Desa> desa;

    public ResponseDesa(List<Desa> name) {
        this.desa = name;
    }

    public List<Desa> getName() {
        return desa;
    }

    public void setName(List<Desa> name) {
        this.desa = name;
    }
}
