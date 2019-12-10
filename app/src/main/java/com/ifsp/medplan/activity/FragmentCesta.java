package com.ifsp.medplan.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ifsp.medplan.R;
import com.ifsp.medplan.adapter.RecyclerViewAdapter2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentCesta extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<Cesta> lstCesta;
    private static final String CESTA_URL = "http://192.168.0.24/cesta.php";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstCesta = new ArrayList<>();
        loadCesta();
    }
    public FragmentCesta() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.cesta_fragment, container, false);
        return v;
    }
    public void loadCesta() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, CESTA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray cesta = new JSONArray(response);
                            for (int i=0; i<cesta.length(); i++){
                                JSONObject cestaObject = cesta.getJSONObject(i);
                                String nome_med = cestaObject.getString("nome_med");
                                String quantidade_estoque = cestaObject.getString("quantidade_estoque");
                                lstCesta.add(new Cesta(nome_med, quantidade_estoque));
                            }
                            myrecyclerview = (RecyclerView) v.findViewById(R.id.cesta_rv);
                            RecyclerViewAdapter2 recyclerViewAdapter2 = new RecyclerViewAdapter2(getContext(), (ArrayList<Cesta>) lstCesta);
                            myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                            myrecyclerview.setAdapter(recyclerViewAdapter2);
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
