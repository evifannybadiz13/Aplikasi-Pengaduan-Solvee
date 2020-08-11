package com.example.psipsi.retorofit.Pengaduan;

import java.io.Serializable;

public class Pengaduan implements Serializable   {
    int id;
    String nik;
    String judul;
    String kategori_pengaduan;
    String provinsi;
    String kabupaten;
    String kecamatan;
    String desa;
    String Lokasi_pengaduan;
    String deskripsi;
    String tanggal;
    String created_at;
    String update_at;
    String nama;
    String diteruskan_ke;
    String alasan_diteruskan;
    String status_pengaduan;

    public Pengaduan(int id, String nik, String judul, String kategori_pengaduan, String provinsi, String kabupaten, String kecamatan, String desa, String lokasi_pengaduan, String deskripsi, String tanggal, String created_at, String update_at, String nama, String diteruskan_ke, String alasan_diteruskan, String status_pengaduan) {
        this.id = id;
        this.nik = nik;
        this.judul = judul;
        this.kategori_pengaduan = kategori_pengaduan;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.desa = desa;
        Lokasi_pengaduan = lokasi_pengaduan;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
        this.created_at = created_at;
        this.update_at = update_at;
        this.nama = nama;
        this.diteruskan_ke = diteruskan_ke;
        this.alasan_diteruskan = alasan_diteruskan;
        this.status_pengaduan = status_pengaduan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori_pengaduan() {
        return kategori_pengaduan;
    }

    public void setKategori_pengaduan(String kategori_pengaduan) {
        this.kategori_pengaduan = kategori_pengaduan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getLokasi_pengaduan() {
        return Lokasi_pengaduan;
    }

    public void setLokasi_pengaduan(String lokasi_pengaduan) {
        Lokasi_pengaduan = lokasi_pengaduan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDiteruskan_ke() {
        return diteruskan_ke;
    }

    public void setDiteruskan_ke(String diteruskan_ke) {
        this.diteruskan_ke = diteruskan_ke;
    }

    public String getAlasan_diteruskan() {
        return alasan_diteruskan;
    }

    public void setAlasan_diteruskan(String alasan_diteruskan) {
        this.alasan_diteruskan = alasan_diteruskan;
    }

    public String getStatus_pengaduan() {
        return status_pengaduan;
    }

    public void setStatus_pengaduan(String status_pengaduan) {
        this.status_pengaduan = status_pengaduan;
    }
}
