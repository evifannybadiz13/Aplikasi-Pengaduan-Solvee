package com.example.psipsi.retorofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCon {
    private static  final  String baseURL = "http://10.0.2.251:81/PengaduanServis/public/";
    private  static RetrofitCon intasiasi;
    private Retrofit retrofit;
    private  RetrofitCon(){
        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public  static  synchronized  RetrofitCon  getInstasiasi(){
        if(intasiasi == null){
            intasiasi = new RetrofitCon();
        }
        return intasiasi;
    }
    public API buatAPI(){
        return retrofit.create(API.class);
    }
}
