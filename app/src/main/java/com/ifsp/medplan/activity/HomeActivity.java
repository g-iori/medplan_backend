package com.ifsp.medplan.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonArray;
import com.ifsp.medplan.R;
import com.ifsp.medplan.adapter.ViewPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private FloatingActionButton fab;

    List<Lembretes> lembretesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fab=findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                CriaDialogo();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Adicione fragment
        adapter.AddFragment(new FragmentLembrete(), "Lembretes");
        adapter.AddFragment(new FragmentCesta(), "Cesta");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void CriaDialogo(){
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_novo_lembrete, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        Spinner tipoMed = (Spinner) view .findViewById(R.id.spinnerTipoMed);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_med, R.layout.custom_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoMed.setAdapter(adapter);

        Spinner intervalo = (Spinner) view .findViewById(R.id.spinnerIntervalo);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.intervalos, R.layout.custom_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intervalo.setAdapter(adapter1);

        Spinner numerais = (Spinner) view .findViewById(R.id.spinnerNumeroTempo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.adm_numero, R.layout.custom_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numerais.setAdapter(adapter2);

        Spinner horaDia = (Spinner) view .findViewById(R.id.spinnerTempo);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.adm_tipo, R.layout.custom_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horaDia.setAdapter(adapter3);

        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        builder.create();
        builder.show();
    }
}
