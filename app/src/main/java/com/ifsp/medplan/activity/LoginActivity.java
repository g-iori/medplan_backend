package com.ifsp.medplan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.ifsp.medplan.R;

public class LoginActivity extends AppCompatActivity {
    EditText login_email, login_senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = (EditText)findViewById(R.id.login_email);
        login_senha = (EditText)findViewById(R.id.login_senha);
    }
    public void OnLogin(View view) {
        String email = login_email.getText().toString();
        String senha = login_senha.getText().toString();
        String type = "login";
        String type_getid = "getid";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, email, senha);
    }

    public void abrirCadastro(View view){
        Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(i);
    }


}
