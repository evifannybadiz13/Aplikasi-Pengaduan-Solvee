package com.example.psipsi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.psipsi.retorofit.Pengaduan.Kabupaten;
import com.example.psipsi.retorofit.Pengaduan.Kecamatan;
import com.example.psipsi.retorofit.Pengaduan.Provinsi;
import com.example.psipsi.retorofit.Pengaduan.ResponseBuatPengaduan;
import com.example.psipsi.retorofit.Pengaduan.ResponseKabupaten;
import com.example.psipsi.retorofit.Pengaduan.ResponseKecamatan;
import com.example.psipsi.retorofit.Pengaduan.ResponsePengaduan;
import com.example.psipsi.retorofit.Pengaduan.ResponseProvinsi;
import com.example.psipsi.retorofit.RetrofitCon;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengaduanFragment extends Fragment {
    EditText tulisan_aduan,lokasi,desripsi;
    Spinner kategori,provinsi,kabupaten,kecamatan,desa;
    Button kirim;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pengaduan, container, false);
        tulisan_aduan = root.findViewById(R.id.tulis_aduan);
        lokasi = root.findViewById(R.id.lokasi);
        desripsi = root.findViewById(R.id.deskripsi);
        kategori = root.findViewById(R.id.kategori);
        provinsi = root.findViewById(R.id.pilih_provinsi);
        kabupaten = root.findViewById(R.id.pilih_kabupaten);
        kirim = root.findViewById(R.id.btn_kirim_aduan);
        kecamatan = root.findViewById(R.id.pilih_kecamatan);
        desa = root.findViewById(R.id.pilih_desa);
        provinsi.setEnabled(false);
        kabupaten.setEnabled(false);
        kecamatan.setEnabled(false);
        desa.setEnabled(false);


        Call<ResponseProvinsi> call = RetrofitCon.getInstasiasi().buatAPI().ambilprovinsi();
        call.enqueue(new Callback<ResponseProvinsi>() {
            @Override
            public void onResponse(Call<ResponseProvinsi> call, Response<ResponseProvinsi> response) {
                final List<String> plantsList = new ArrayList<>();
                plantsList.add("-Pilih Provinsi-");
                for(Provinsi x : response.body().getName()){
                        plantsList.add(x.getName());
                }

                final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String >(getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList);
                provinsi.setAdapter(spinnerArrayAdapter);
                provinsi.setEnabled(true);

            }

            @Override
            public void onFailure(Call<ResponseProvinsi> call, Throwable t) {
                TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);

            }
        });
        Call<ResponseProvinsi> call5 = RetrofitCon.getInstasiasi().buatAPI().ambilkategori();
        call5.enqueue(new Callback<ResponseProvinsi>() {
            @Override
            public void onResponse(Call<ResponseProvinsi> call, Response<ResponseProvinsi> response) {
                final List<String> plantsList = new ArrayList<>();
                plantsList.add("-Pilih Kategori--");
                for(Provinsi x : response.body().getName()){
                    plantsList.add(x.getName());
                }

                final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String >(getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList);
                kategori.setAdapter(spinnerArrayAdapter);
                kategori.setEnabled(true);
            }

            @Override
            public void onFailure(Call<ResponseProvinsi> call, Throwable t) {
                TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);

            }
        });



        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tulisan_aduan.getText().length() == 0){
                    tulisan_aduan.setError("Isi aduan tidak boleh kosong");
                    return;
                }
                else if (lokasi.getText().length() == 0){
                    lokasi.setError("Lokasi tidak boleh kosong");
                    return;
                }
                else if (desripsi.getText().length() == 0){
                    desripsi.setError("Deskripsi tidak boleh kosong");
                    return;
                }
                else if(kategori.getSelectedItemPosition() == 0){
                    TastyToast.makeText(getContext(),"Pilih salah satu kategori",5000,TastyToast.WARNING);
                    return;
                }
                else if(provinsi.getSelectedItemPosition() == 0){
                    TastyToast.makeText(getContext(),"Pilih salah satu provinsi",5000,TastyToast.WARNING);
                    return;
                }
                else if(kabupaten.getSelectedItemPosition() == 0){
                    TastyToast.makeText(getContext(),"Pilih salah satu kabupaten",5000,TastyToast.WARNING);
                    return;
                }
                else if(kecamatan.getSelectedItemPosition() == 0){
                    TastyToast.makeText(getContext(),"Pilih salah satu kecamatan",5000,TastyToast.WARNING);
                    return;
                }
                else if(desa.getSelectedItemPosition() == 0){
                    TastyToast.makeText(getContext(),"Pilih salah satu desa",5000,TastyToast.WARNING);
                    return;
                }
                else{
                    Call<ResponseBuatPengaduan> call6 = RetrofitCon.getInstasiasi().buatAPI().tambahpengaduan(Prefences.getInstance(getContext()).getUser().getName(),Prefences.getInstance(getContext()).getUser().getNik(),provinsi.getSelectedItem().toString(),kabupaten.getSelectedItem().toString(),kategori.getSelectedItem().toString(),kecamatan.getSelectedItem().toString(),desa.getSelectedItem().toString(),desripsi.getText().toString().trim(),tulisan_aduan.getText().toString().trim(),lokasi.getText().toString().trim());
                    call6.enqueue(new Callback<ResponseBuatPengaduan>() {
                        @Override
                        public void onResponse(Call<ResponseBuatPengaduan> call, Response<ResponseBuatPengaduan> response) {
                            tulisan_aduan.setText("");
                            lokasi.setText("");
                            desripsi.setText("");
                            kategori.setSelection(0);
                            provinsi.setSelection(0);
                            kabupaten.setSelection(0);
                            kecamatan.setSelection(0);
                            desa.setSelection(0);
                            TastyToast.makeText(getContext(),"Berhasil Menambahkan",5000,TastyToast.SUCCESS);

                        }

                        @Override
                        public void onFailure(Call<ResponseBuatPengaduan> call, Throwable t) {
                            TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);
                        }
                    });
                }


            }
        });
        provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    Call<ResponseKabupaten> call2 = RetrofitCon.getInstasiasi().buatAPI().ambilkabupaten(provinsi.getSelectedItem().toString());
                    call2.enqueue(new Callback<ResponseKabupaten>() {
                        @Override
                        public void onResponse(Call<ResponseKabupaten> call, Response<ResponseKabupaten> response) {
                            final List<String> plantsList = new ArrayList<>();
                            plantsList.add("-Pilih Kabupaten-");
                            for(Kabupaten x : response.body().getName()){
                                plantsList.add(x.getName());
                            }

                            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String >(getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList);
                            kabupaten.setAdapter(spinnerArrayAdapter);
                            kabupaten.setEnabled(true);

                        }

                        @Override
                        public void onFailure(Call<ResponseKabupaten> call, Throwable t) {
                            TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);

                        }
                    });
                }
                else {
                    kabupaten.setEnabled(false);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        kabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Call<ResponseKecamatan> call3 = RetrofitCon.getInstasiasi().buatAPI().ambilkecamatan(kabupaten.getSelectedItem().toString());
                if(position != 0){
                    call3.enqueue(new Callback<ResponseKecamatan>() {
                        @Override
                        public void onResponse(Call<ResponseKecamatan> call, Response<ResponseKecamatan> response) {
                            final List<String> plantsList = new ArrayList<>();
                            plantsList.add("-Pilih Kecamatan-");
                            for(Kecamatan x : response.body().getName()){
                                plantsList.add(x.getName());
                            }

                            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String >(getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList);
                            kecamatan.setAdapter(spinnerArrayAdapter);
                            kecamatan.setEnabled(true);
                        }

                        @Override
                        public void onFailure(Call<ResponseKecamatan> call, Throwable t) {
                            TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);
                        }
                    });
                }
                else {
                    kecamatan.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        kecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Call<ResponseKecamatan> call8 = RetrofitCon.getInstasiasi().buatAPI().ambildesa(kecamatan.getSelectedItem().toString());
                if(position != 0){
                    call8.enqueue(new Callback<ResponseKecamatan>() {
                        @Override
                        public void onResponse(Call<ResponseKecamatan> call, Response<ResponseKecamatan> response) {
                            final List<String> plantsList = new ArrayList<>();
                            plantsList.add("-Pilih Desa-");
                            for(Kecamatan x : response.body().getName()){
                                plantsList.add(x.getName());
                            }

                            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String >(getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList);
                            desa.setAdapter(spinnerArrayAdapter);
                            desa.setEnabled(true);
                        }

                        @Override
                        public void onFailure(Call<ResponseKecamatan> call, Throwable t) {
                            TastyToast.makeText(getContext(),"Fail " + t.getMessage(),5000,TastyToast.ERROR);
                        }
                    });
                }
                else {
                    desa.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
