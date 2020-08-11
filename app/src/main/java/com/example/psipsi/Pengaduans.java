package com.example.psipsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.psipsi.retorofit.Pengaduan.Pengaduan;

public class Pengaduans extends AppCompatActivity {
    Intent i = getIntent();
    Pengaduan data;
    TextView judul,nik,nama,deksripsi,lokasi,detail,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduans);
        data = (Pengaduan) getIntent().getSerializableExtra("data");
        judul = findViewById(R.id.judulnya);
        nik = findViewById(R.id.niknya);
        nama = findViewById(R.id.namanya);
        deksripsi = findViewById(R.id.deskripsinya);
        lokasi = findViewById(R.id.lokasinya);
        detail = findViewById(R.id.detailnya);
        status = findViewById(R.id.statusnya);
        judul.setText("Judul : " + data.getJudul());
        nik.setText("NIK : " + data.getNik());
        nama.setText("Nama" + data.getNama());
        deksripsi.setText("Deskripsi : " + data.getDeskripsi());
        lokasi.setText("Lokasi : Provinsi " + data.getProvinsi() + ", Kabupaten " + data.getKabupaten() + ", Kecamatan " + data.getKecamatan() + ", Desa : " +data.getDesa());
        detail.setText("Detail Lokasi : " + data.getLokasi_pengaduan());
        status.setText("Status : " + data.getStatus_pengaduan());

    }
}