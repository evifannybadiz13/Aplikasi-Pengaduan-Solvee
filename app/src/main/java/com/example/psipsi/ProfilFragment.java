package com.example.psipsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sdsmdg.tastytoast.TastyToast;

public class ProfilFragment extends Fragment {
    TextView nama;
    TextView keluar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profil, container, false);
        nama =  root.findViewById(R.id.namaprofil);
        nama.setText(Prefences.getInstance(getContext()).getUser().getName());
        keluar = root.findViewById(R.id.keluar);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefences.getInstance(getContext()).clear();
                TastyToast.makeText(getContext(),"Akun telah logout",5000,TastyToast.SUCCESS);
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
