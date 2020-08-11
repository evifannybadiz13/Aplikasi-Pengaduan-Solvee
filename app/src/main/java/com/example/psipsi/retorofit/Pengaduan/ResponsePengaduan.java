package com.example.psipsi.retorofit.Pengaduan;

import java.util.List;

public class ResponsePengaduan {
    String status;
    List<Pengaduan> pengaduan;

    public ResponsePengaduan(String status, List<Pengaduan> pengaduan) {
        this.status = status;
        this.pengaduan = pengaduan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pengaduan> getPengaduan() {
        return pengaduan;
    }

    public void setPengaduan(List<Pengaduan> pengaduan) {
        this.pengaduan = pengaduan;
    }
}
