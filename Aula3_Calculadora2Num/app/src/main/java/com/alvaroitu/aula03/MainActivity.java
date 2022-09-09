package com.alvaroitu.aula03;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText numero1;
    EditText numero2;

    Button botaoAdicao;
    Button botaoSubtracao;
    Button botaoMultiplicacao;
    Button botaoDivisao;

    TextView resultadoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.editTextNumero1);
        numero2 = findViewById(R.id.editTextNumero2);

        botaoAdicao = findViewById(R.id.buttonAdicao);
        botaoSubtracao = findViewById(R.id.buttonSubtracao);
        botaoMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        botaoDivisao = findViewById(R.id.buttonDivisao);

        resultadoLayout = findViewById(R.id.textViewResultado);

        final DecimalFormat df = new DecimalFormat("0.00");

        botaoAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) +
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoLayout.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaoSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) -
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoLayout.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaoMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) *
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoLayout.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botaoDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) /
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoLayout.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}