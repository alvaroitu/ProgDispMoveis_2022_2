package com.alvaroitu.aula06;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText nacionalidade;
    Button salvar;
    TextView dadosRecuperados;
    Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        nacionalidade = findViewById(R.id.nacionalidade);
        salvar = findViewById(R.id.salvar);
        dadosRecuperados = findViewById(R.id.dadosRecuperados);
        deletar = findViewById(R.id.deletar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("dados",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editaPrefs = prefs.edit();

                String nomeSalvo = nome.getText().toString();
                String nacionalidadeSalva = nacionalidade.getText().toString();

                editaPrefs.putString("nome", nomeSalvo);
                editaPrefs.putString("nacionalidade", nacionalidadeSalva);
                editaPrefs.apply();

                dadosRecuperados.setText("Nome: " + nomeSalvo + " \n Nacionalidade: "
                        + nacionalidadeSalva);

                Toast.makeText(MainActivity.this, "Dados salvos",
                        Toast.LENGTH_SHORT).show();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("dados",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editaPrefs = prefs.edit();
                editaPrefs.clear().apply();
                nome.setText("");
                nacionalidade.setText("");
                dadosRecuperados.setText("");
                Toast.makeText(MainActivity.this, "Dados deletados", Toast.LENGTH_SHORT).show();
            }
        });
        SharedPreferences prefs = getSharedPreferences("dados", Context.MODE_PRIVATE);
        dadosRecuperados.setText("Nome: " + prefs.getString("nome", "não encontrado")
                + " \n Nacionalidade: " +
                prefs.getString("nacionalidade", "nao encontrado"));
    }
}