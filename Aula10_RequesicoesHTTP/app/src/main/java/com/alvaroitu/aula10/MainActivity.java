package com.alvaroitu.aula10;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button botaoRecuperar;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoRecuperar = findViewById(R.id.botaoRecuperar);
        textoResultado = findViewById(R.id.textoResultado);

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                String urlApi = "https://blockchain.info/ticker";
                String cep = "13309710";
                String urlCep = "https://viacep.com.br/ws/" + cep + "/json/";
                task.execute(urlApi);
            }
        });
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;
            try {
                URL url = new URL(stringUrl);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                // Recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                inputStreamReader = new InputStreamReader( inputStream );

                //Objeto utilizado para leitura dos caracteres do InpuStreamReader
                BufferedReader reader = new BufferedReader( inputStreamReader );
                buffer = new StringBuffer();
                String linha = "";

                while((linha = reader.readLine()) != null){
                    buffer.append( linha );
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
//            String cep = null;
//            String logradouro = null;
//            String bairro = null;
//            String localidade = null;
//            String uf = null;
//            try {
//                JSONObject jsonObject = new JSONObject(resultado);
//                cep = jsonObject.getString("cep");
//                logradouro = jsonObject.getString("logradouro");
//                bairro = jsonObject.getString("bairro");
//                localidade = jsonObject.getString("localidade");
//                uf = jsonObject.getString("uf");

//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            textoResultado.setText(resultado);
//            textoResultado.setText(logradouro + "\n" + bairro + "\n" +
//                    localidade + "\n" + uf  + "\n" + cep );

        }
    }
}