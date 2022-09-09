package com.alvaroitu.aula02;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortearNumero(View view){

        TextView resultado = findViewById(R.id.resultado);

        int numeroSorteado = new Random().nextInt(10) + 1;

        resultado.setText("Número sorteado: " + numeroSorteado);

    }
}