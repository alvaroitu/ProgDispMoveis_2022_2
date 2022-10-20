package com.alvaroitu.aula08;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Switch switch1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        textView = findViewById(R.id.textView);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (switch1.isChecked()) {
                    textView.setText("O Palmeiras TEM Mundial!!!");
                } else {
                    textView.setText("O Palmeiras NÃO TEM Mundial!!!");
                }
            }
        });
    }

    public void iniciarThread(View view) {
        for (int i = 1; i <= 100; i++) {
            Log.d("Thread", "Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    Log.d("Thread", "Contador: " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        new Thread(runnable).start();
    }
}