package com.ifsp.medplan.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.ifsp.medplan.R;
import com.ifsp.medplan.activity.Lembretes;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Lembretes> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context context, ArrayList<Lembretes> mData) {
        this.mContext = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lembrete_med, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_novo_lembrete);



        vHolder.item_lembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });
        return  vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome_med.setText(mData.get(position).getNome_med());
        holder.dosagem_med.setText(mData.get(position).getDosagem_med());
        holder.horario_med.setText(mData.get(position).getHorario_med());
        holder.adm_med.setText(mData.get(position).getAdm_med());

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nome_med;
        private TextView dosagem_med;
        private TextView horario_med;
        private TextView adm_med;
        private LinearLayout item_lembrete;
        RelativeLayout lembreteLayout;

        //private ImageView img_tipo;
        public MyViewHolder(View itemView) {
            super(itemView);

            item_lembrete = (LinearLayout) itemView.findViewById(R.id.item_lembrete);
            //img_tipo = itemView.findViewById(R.id.tipo_med);
            nome_med = itemView.findViewById(R.id.nome_med);
            dosagem_med = itemView.findViewById(R.id.dosagem_med);
            horario_med = itemView.findViewById(R.id.tipo_med);
            adm_med = itemView.findViewById(R.id.adm_med);
            lembreteLayout = itemView.findViewById(R.id.lembrete_rv);

        }
    }
}
