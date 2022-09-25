package com.alvaroitu.aula04;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Switch mundial;
    ToggleButton ligado;
    TextView mensagemSwitch;
    TextView mensagemToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mundial = findViewById(R.id.switchMundial);
        ligado = findViewById(R.id.toggleButtonLigado);
        mensagemSwitch = findViewById(R.id.textViewSwitch);
        mensagemToggleButton = findViewById(R.id.textViewToggleButton);

        mundial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (mundial.isChecked()){

                    mensagemSwitch.setText("O Palmeiras TEM Mundial!!!");
                } else {

                    mensagemSwitch.setText("O Palmeiras NÃO TEM Mundial!!!");
                }
            }
        });

    }

    public void alterarLigado(View view){
        if (ligado.isChecked()){
            mensagemToggleButton.setText("ligado");
        } else {
            mensagemToggleButton.setText("desligado");
        }
    }
}