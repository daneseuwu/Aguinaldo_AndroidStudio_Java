package com.dbz.aguinaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Options extends AppCompatActivity {

    CheckBox chkAguinaldoProporcional, chkAguinaldo;
    boolean option, proporcional, aguinaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_options);

        chkAguinaldoProporcional = findViewById(R.id.chkAguinaldoProporcional);
        chkAguinaldo = findViewById(R.id.chkOptionAguinaldo);

    }


    public void optionSeleccionado(View v) {

        if (!chkAguinaldo.isChecked() && !chkAguinaldoProporcional.isChecked()) {
            Toast.makeText(this, "Selecciona una opcion", Toast.LENGTH_SHORT).show();

        } else if (chkAguinaldo.isChecked() && chkAguinaldoProporcional.isChecked()) {
            Toast.makeText(this, "Selecciona una opcion a la vez", Toast.LENGTH_SHORT).show();

        } else if (chkAguinaldoProporcional.isChecked()) {
            Intent lanzar = new Intent(this, DataProporcional.class);
            startActivity(lanzar);
            finish();

        } else if (chkAguinaldo.isChecked()) {
            Intent lanzar = new Intent(this, DataAguinaldo.class);
            startActivity(lanzar);
            finish();

        }

    }


    public void Salir(View v) {
        finish();
    }
}