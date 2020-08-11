package com.example.psipsi.recycleAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psipsi.HalamanPengaduan;
import com.example.psipsi.Pengaduans;
import com.example.psipsi.R;
import com.example.psipsi.retorofit.Pengaduan.Pengaduan;

import java.io.Serializable;
import java.util.List;

public class pengaduanAdapter extends RecyclerView.Adapter<pengaduanAdapter.Holder>{
    private List<Pengaduan> data;
    Context context;
    public pengaduanAdapter(List<Pengaduan> data,Context context){
        this.data = data;
        this.context =context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_pengaduan,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final Pengaduan list = this.data.get(position);
        holder.judul.setText(list.getJudul());
        holder.pembuat.setText("Dibuat oleh : " + list.getNama());
        holder.isi.setText(list.getDeskripsi());
        holder.tanggal.setText(list.getTanggal());
        holder.status.setText("Status : " + list.getStatus_pengaduan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, Pengaduans.class);
                intent.putExtra("data", list);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView judul;
        TextView  pembuat;
        TextView isi;
        TextView tanggal;
        TextView status;
        public Holder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            pembuat = itemView.findViewById(R.id.pembuat);
            isi = itemView.findViewById(R.id.isi);
            tanggal = itemView.findViewById(R.id.tanggal);
            status= itemView.findViewById(R.id.status);
        }
    }

}
