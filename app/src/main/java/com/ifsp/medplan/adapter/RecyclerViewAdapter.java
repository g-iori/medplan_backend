package com.ifsp.medplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ifsp.medplan.R;
import com.ifsp.medplan.activity.Lembretes;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Lembretes> mData;

    public RecyclerViewAdapter(Context mContext, List<Lembretes> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.lembrete_med, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome_med.setText(mData.get(position).getNome_med());
        holder.dosagem_med.setText(mData.get(position).getDosagem_med());
        holder.horario_med.setText(mData.get(position).getHorario_med());
        holder.img_tipo.setImageResource(mData.get(position).getTipo_med());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nome_med;
        private TextView dosagem_med;
        private TextView horario_med;
        private ImageView img_tipo;
        public MyViewHolder (View itemView){
            super(itemView);

            img_tipo = itemView.findViewById(R.id.tipo_med);
            nome_med = itemView.findViewById(R.id.nome_med);
            dosagem_med = itemView.findViewById(R.id.dosagem_med);
            horario_med = itemView.findViewById(R.id.horario_med);
        }
    }
}
