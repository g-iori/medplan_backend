package com.ifsp.medplan.adapter;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ifsp.medplan.R;
import com.ifsp.medplan.activity.Cesta;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder> {
        private Context mContext;
        private ArrayList<Cesta> mData;
        Dialog myDialog;

        public RecyclerViewAdapter2(Context context, ArrayList<Cesta> mData) {
            this.mContext = context;
            this.mData = mData;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v;
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.estoque_med, parent, false);
            MyViewHolder vHolder = new MyViewHolder(v);

            myDialog = new Dialog(mContext);
            myDialog.setContentView(R.layout.dialog_novo_medicamento);



            vHolder.item_cesta.setOnClickListener(new View.OnClickListener() {
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
            holder.quantidade_estoque.setText(mData.get(position).getQuantidade_med());

        }

        @Override
        public int getItemCount() {

            return mData.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView nome_med;
            private TextView quantidade_estoque;
            private LinearLayout item_cesta;
            RelativeLayout cestaLayout;

            //private ImageView img_tipo;
            public MyViewHolder(View itemView) {
                super(itemView);

                item_cesta = (LinearLayout) itemView.findViewById(R.id.item_cesta);
                //img_tipo = itemView.findViewById(R.id.tipo_med);
                nome_med = itemView.findViewById(R.id.nome_med_cesta);
                quantidade_estoque = itemView.findViewById(R.id.quantidade_estoque);
                cestaLayout = itemView.findViewById(R.id.cesta_rv);
            }
        }
    }
