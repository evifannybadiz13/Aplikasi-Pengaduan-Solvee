package com.example.psipsi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psipsi.retorofit.RetrofitCon;
import com.example.psipsi.retorofit.user.UserResponse;
import com.sdsmdg.tastytoast.TastyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button masuk;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        TextView daftar = (TextView)findViewById(R.id.txtDaftar);
        email =findViewById(R.id.emaile);
        password = findViewById(R.id.passworde);
        masuk = findViewById(R.id.btn_masuk);

        daftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent a = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(a);
            }
        });
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btn_detail_back:
                    Intent intent = new Intent(Foods.this, BerandaFragment.class);
                    startActivity(intent);
                    break;
                case R.id.btn_detail_like:
                    Toast.makeText(Foods.this, "Anda menyukai Post Makanan ini", Toast.LENGTH_SHORT).show();
                    break;

            }
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.length() == 0){
                    email.setError("Email tidak boleh kosong");
                    return;
                }
                else if(password.length() < 9){
                    password.setError("Password tidak boleh kosong");
                    return;
                }
                else{
                    String emails = email.getText().toString().trim();
                    String passwords = password.getText().toString().trim();
                    Call<UserResponse> call = RetrofitCon.getInstasiasi().buatAPI().userLogin(emails,passwords);
                    call.enqueue(new Callback<UserResponse>() {
                        @Override
                        public void onResponse(Call<UserResponse> call, final Response<UserResponse> response) {

                            final UserResponse userLogin = response.body();
                            if(userLogin.getStatus().equals("success")){
                                Prefences.getInstance(MainActivity.this)
                                        .saveUser(userLogin.getUser());
                                TastyToast.makeText(getApplicationContext(),"Login berhasil sebagai " + userLogin.getUser().getName(),5000,TastyToast.SUCCESS);

                                final Intent intent = new Intent(getApplicationContext(),ButtonNavActivity.class);
                                        startActivity(intent);
                                        finish();
                            }
                            else{
                                TastyToast.makeText(getApplicationContext(),"Username atau Password salah",5000,TastyToast.ERROR);
                            }
                        }

                        @Override
                        public void onFailure(Call<UserResponse> call, Throwable t) {
                            System.out.println(t.getMessage());
                            TastyToast.makeText(getApplicationContext(),"Salah karena" + t.getMessage(),5000,TastyToast.WARNING);
                        }
                    });
                }

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (Prefences.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, ButtonNavActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
