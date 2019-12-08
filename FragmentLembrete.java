package com.ifsp.medplan.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ifsp.medplan.R;
import com.ifsp.medplan.adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentLembrete extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<Lembretes> lstLembretes;
    private static final String LEMBRETE_URL = "http://192.168.0.24/lembrete.php";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstLembretes = new ArrayList<>();
        loadLembretes();
    }

    public FragmentLembrete() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.lembrete_fragment, container, false);

        return v;
    }
    public void loadLembretes() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, LEMBRETE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray lembretes = new JSONArray(response);
                            for (int i=0; i<lembretes.length(); i++){
                                JSONObject lembreteObject = lembretes.getJSONObject(i);
                                String nome_medicamento = lembreteObject.getString("nome_medicamento");
                                String dose_lemb = lembreteObject.getString("dose_lemb");
                                String tipo_medicamento = lembreteObject.getString("tipo_medicamento");
                                String adm_lemb = lembreteObject.getString("adm_lemb");
                                lstLembretes.add(new Lembretes(nome_medicamento, dose_lemb, tipo_medicamento, adm_lemb+" em "+adm_lemb+" horas"));
                            }
                            myrecyclerview = (RecyclerView) v.findViewById(R.id.lembrete_rv);
                            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstLembretes);
                            myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                            myrecyclerview.setAdapter(recyclerViewAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }


}
