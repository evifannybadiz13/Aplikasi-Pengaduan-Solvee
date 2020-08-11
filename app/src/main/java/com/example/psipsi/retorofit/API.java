package com.example.psipsi.retorofit;


import com.example.psipsi.retorofit.Pengaduan.ResponseBuatPengaduan;
import com.example.psipsi.retorofit.Pengaduan.ResponseKabupaten;
import com.example.psipsi.retorofit.Pengaduan.ResponseKecamatan;
import com.example.psipsi.retorofit.Pengaduan.ResponsePengaduan;
import com.example.psipsi.retorofit.Pengaduan.ResponseProvinsi;
import com.example.psipsi.retorofit.user.RegisterResponse;
import com.example.psipsi.retorofit.user.UserResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("finduser")
    Call<UserResponse> userLogin(
            @Field("email") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("createuser")
    Call<RegisterResponse> register(
            @Field("nama") String nama,
            @Field("email") String username,
            @Field("password") String password,
            @Field("nik") String NIK,
            @Field("alamat") String alamat,
            @Field("nomor") String nomor

    );
    @FormUrlEncoded
    @POST("buatpengaduan")
    Call<ResponseBuatPengaduan> tambahpengaduan(
            @Field("nama") String nama,
            @Field("nik") String nik,
            @Field("provinsi") String provinsi,
            @Field("kabupaten") String kabupaten,
            @Field("kategori") String kategori,
            @Field("kecamatan") String kecamatan,
            @Field("desa") String desa,
            @Field("deskripsi") String deskripsi,
            @Field("judul") String judul,
            @Field("lokasi") String lokasi

    );
    @GET("datapengaduan")
    Call<ResponsePengaduan> ambilpengaduan();
    @GET("provinsi")
    Call<ResponseProvinsi> ambilprovinsi();
    @GET("kategori")
    Call<ResponseProvinsi> ambilkategori();
    @FormUrlEncoded
    @POST("kabupaten")
    Call<ResponseKabupaten> ambilkabupaten(
            @Field("provinsi") String provinsi
    );


    @FormUrlEncoded
    @POST("kecamatan")
    Call<ResponseKecamatan> ambilkecamatan(
            @Field("kabupaten") String kabupaten
    );
    @FormUrlEncoded
    @POST("desa")
    Call<ResponseKecamatan> ambildesa(
            @Field("kecamatan") String kecamatan
    );
}
