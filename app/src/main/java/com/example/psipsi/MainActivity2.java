package com.example.psipsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.psipsi.ui.mainactivity2.MainActivity2Fragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainActivity2Fragment.newInstance())
                    .commitNow();
        }
    }
}
