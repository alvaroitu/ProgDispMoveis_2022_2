package com.alvaroitu.aula01;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView textoParaAlterar;

    Button botaoCliqueAqui1;
    Button botaoHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoParaAlterar = findViewById(R.id.textoParaAlterar);

        botaoCliqueAqui1 = findViewById(R.id.botaoCliqueAqui1);
        botaoHelloWorld = findViewById(R.id.botaoHelloWorld);

        botaoCliqueAqui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello World 1!!!", Toast.LENGTH_SHORT).show();
            }
        });

        botaoHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoParaAlterar.setText("Hello World");
            }
        });
    }

    public void showHelloWorld(View view) {

        Toast.makeText(this, "Hello World 2!!!",
                Toast.LENGTH_SHORT).show();
    }

    public void alterarText(View view) {
        textoParaAlterar.setText("Olá Mundo");
    }
}