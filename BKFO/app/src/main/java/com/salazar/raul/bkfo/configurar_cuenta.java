package com.salazar.raul.bkfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class configurar_cuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.configurar_cuenta);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_configuracion);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Configurar Cuenta");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
}
