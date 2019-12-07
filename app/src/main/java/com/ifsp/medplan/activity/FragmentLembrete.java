package com.ifsp.medplan.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ifsp.medplan.R;
import com.ifsp.medplan.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentLembrete extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<Lembretes> lstLembretes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstLembretes = new ArrayList<>();
        lstLembretes.add(new Lembretes("Paracetamol", "2 Comprimidos", "8 em 8 horas", 1));
    }

    public FragmentLembrete() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.lembrete_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.lembrete_rv);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstLembretes);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }
}
