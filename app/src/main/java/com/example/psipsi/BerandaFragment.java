package com.example.psipsi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psipsi.recycleAdapter.pengaduanAdapter;
import com.example.psipsi.retorofit.Pengaduan.Pengaduan;
import com.example.psipsi.retorofit.Pengaduan.ResponsePengaduan;
import com.example.psipsi.retorofit.RetrofitCon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_beranda, container, false);
        recyclerView = root.findViewById(R.id.daftarPengaduan);
        recyclerView.setHasFixedSize(true);
        tampilkanDaftar();
        return root;
    }

    public void tampilkanDaftar() {
        Call<ResponsePengaduan> call = RetrofitCon.getInstasiasi().buatAPI().ambilpengaduan();
        call.enqueue(new Callback<ResponsePengaduan>() {
            @Override
            public void onResponse(Call<ResponsePengaduan> call, Response<ResponsePengaduan> response) {
                ResponsePengaduan respon = response.body();
                List<Pengaduan> pengu = respon.getPengaduan();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                pengaduanAdapter listHeroAdapter = new pengaduanAdapter(pengu,getContext());
                recyclerView.setAdapter(listHeroAdapter);

            }


            @Override
            public void onFailure(Call<ResponsePengaduan> call, Throwable t) {

            }
        });
    }
}
