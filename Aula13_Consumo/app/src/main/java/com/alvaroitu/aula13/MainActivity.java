package com.alvaroitu.aula13;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);  // definição e link da variável com a view plaintext distancia
        TextView textView = findViewById(R.id.textView);  // definição e link da variável com a view textview
        Button button = findViewById(R.id.button);        // definição e link da variável com a view button
        EditText editTex2 = findViewById(R.id.editText2); // definição e link da variável com a view plaintext autonomia

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double automia = Double.parseDouble(editTex2.getText().toString());  // quanto o carro faz por litro - variavel definida aqui
                    Double distancia = Double.parseDouble(editText.getText().toString());  // recuperando informação digitada na plain text

                    Double consumoTotal = distancia / automia; // calculo do consumo total

                    textView.setText("O Consumo total será: " + decimalFormat.format(consumoTotal) + " litros de combustível"); // mostrando o resultado na textview

                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Entre com dados...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}