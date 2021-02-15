package com.example.geolocalizacionmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton botonIngresar;
    private EditText et1,et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonIngresar = (ImageButton) findViewById(R.id.btnIngresar);
        findViewById(R.id.btnIngresar).setOnClickListener(this);
        et1 = (EditText) findViewById(R.id.etUsuario);
        et2 = (EditText) findViewById(R.id.etPassword);
        tv1 = (TextView) findViewById(R.id.txtMensaje);

        tv1.setVisibility(View.INVISIBLE);



        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c)
            {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(et1.getText().toString().length() != 0 && et2.getText().toString().length() != 0) {
                    tv1.setVisibility(View.VISIBLE);
                    tv1.setText("Haga click en la pokeball");
                }
            }
        };

        et1.addTextChangedListener(textWatcher);
        et2.addTextChangedListener(textWatcher);

    }


    @Override
    public void onClick(View v) {

        if (et1.getText().toString().isEmpty()){
            Toast.makeText(this, "Campo Nombre vacio", Toast.LENGTH_LONG).show();
        }else {
            if (et2.getText().toString().isEmpty()){
                Toast.makeText(this, "Contraseña sin introducir", Toast.LENGTH_LONG).show();
            }
        }

        if(et1.getText().toString().length() !=0 && et2.getText().toString().length() !=0) {
            Intent i = new Intent(this,Mapa.class);
            startActivity(i);
        }

    }

}