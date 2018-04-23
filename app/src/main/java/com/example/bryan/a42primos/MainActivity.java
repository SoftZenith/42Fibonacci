package com.example.bryan.a42primos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResultado;
    EditText txtNumero;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        txtNumero = findViewById(R.id.txtNumero);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new fibonacci().execute();
            }
        });

    }

    private class fibonacci extends AsyncTask<StringBuilder, Object, StringBuilder> {

        int numero = Integer.parseInt(txtNumero.getText().toString());


        int fibonacci(int n)
        {
            if (n>1){
                return fibonacci(n-1) + fibonacci(n-2);
            }
            else if (n==1) {
                return 1;
            }
            else if (n==0){
                return 0;
            }
            else{
                return -1;
            }
        }

        @Override
        protected StringBuilder doInBackground(StringBuilder... strings) {
            StringBuilder li = new StringBuilder();

            for(int i = 0; i <= numero; i++){
                li.append(fibonacci(i)+"\n");
            }

            return li;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(StringBuilder s) {
            txtResultado.setText(s.toString());
        }

    }



}
