package com.ifsp.medplan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ifsp.medplan.R;

public class CadastroActivity extends AppCompatActivity {
    EditText cadastro_nome, cadastro_email, cadastro_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        cadastro_nome = findViewById(R.id.cadastro_nome);
        cadastro_email = findViewById(R.id.cadastro_email);
        cadastro_senha = findViewById(R.id.cadastro_senha);

    }
    public void OnReg(View view){
        String str_nome = cadastro_nome.getText().toString();
        String str_email = cadastro_email.getText().toString();
        String str_senha = cadastro_senha.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_nome, str_email, str_senha);
    }
}
