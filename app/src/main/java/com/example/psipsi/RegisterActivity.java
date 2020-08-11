package com.example.psipsi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.psipsi.retorofit.RetrofitCon;
import com.example.psipsi.retorofit.user.RegisterResponse;
import com.sdsmdg.tastytoast.TastyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText nik,nama_lengkap,email,password,konfirPassword;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Daftar");
        nik = findViewById(R.id.nik);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        konfirPassword = findViewById(R.id.konfirpassword);
        Button registrasi = (Button)findViewById(R.id.btn_register);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(nik.getText().length() == 0){
                nik.setError("NIK tidak boleh kosong");
                return;
            }
                else if(email.getText().length() == 0){
                    email.setError("Email tidak boleh kosong");
                    return;
                }
            else if(nama_lengkap.getText().length() == 0){
                nama_lengkap.setError("Nama lengkap tidak boleh kosong");
                return;
            }
                else if(password.length() < 9){
                    password.setError("Password tidak boleh kosong dan minimum 9 karakter");
                    return;
                }
                else if(konfirPassword.length() < 9){
                    konfirPassword.setError("Konfirmasi password tidak boleh kosong dan minimum 9 karakter");
                    return;
                }
                else if(!password.getText().toString().trim().equals(konfirPassword.getText().toString().trim())){
                    password.requestFocus();
                    konfirPassword.requestFocus();
                    TastyToast.makeText(getApplicationContext(),"Password tidak sesuai dengan konfirmasi password",5000,TastyToast.ERROR);
                return;
                }
                if(nik.getText().length() == 0){
                    nik.setError("NIK tidak boleh kosong");
                    return;
                }
                if(nik.getText().length() == 0){
                    nik.setError("NIK tidak boleh kosong");
                    return;
                }
                Call<RegisterResponse> call = RetrofitCon.getInstasiasi().buatAPI().register(nama_lengkap.getText().toString(),email.getText().toString().trim(),password.getText().toString().trim(),nik.getText().toString().trim(),"11","11");
                call.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, final Response<RegisterResponse> response) {

                        final RegisterResponse userLogin = response.body();
                        if(userLogin.getStatus().equals("success")){
                            TastyToast.makeText(getApplicationContext(),"Berhasil Mendaftar",5000,TastyToast.SUCCESS);


                            Intent a = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(a);
                        }
                        else if(userLogin.getStatus().equals("sudah ada")){
                            email.setError("Email sudah pernah digunakan");
                            email.requestFocus();
                            TastyToast.makeText(getApplicationContext(),"Email yang anda masukkan telah pernah digunakan",5000,TastyToast.SUCCESS);

                        }
                        else{
                            TastyToast.makeText(getApplicationContext(),"Tidak dapat mendaftar",5000,TastyToast.ERROR);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        System.out.println(t.getMessage());
                        TastyToast.makeText(getApplicationContext(),"Salah karena" + t.getMessage(),5000,TastyToast.WARNING);
                    }
                });

            }
        });

    }


}
