package com.dbz.aguinaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DataAguinaldo extends AppCompatActivity {

    EditText txtsalarioMensual, txtAniosLaborales;
    String salarioMensual, aniosLaborados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_aguinaldo);

        txtsalarioMensual = findViewById(R.id.txtEditSalarioMensual);
        txtAniosLaborales = findViewById(R.id.txtEditAniosLaborados);

    }

    public void calcularAguinaldo(View v) {
        salarioMensual = txtsalarioMensual.getText().toString();
        aniosLaborados = txtAniosLaborales.getText().toString();

        if (salarioMensual.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su salario mensual", Toast.LENGTH_SHORT).show();
        } else if (aniosLaborados.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese los años laborados", Toast.LENGTH_SHORT).show();

        } else {
            Intent enviaraResult = new Intent(DataAguinaldo.this, result_aguinaldo.class);
            enviaraResult.putExtra("salario", salarioMensual);
            enviaraResult.putExtra("aniosLaborados", aniosLaborados);

            startActivity(enviaraResult);

            finish();
        }
    }

    public void irPantallaOpciones(View v) {
        Intent lanzar = new Intent(this, Options.class);
        startActivity(lanzar);
        finish();
    }

    public void salir(View v) {
        finish();
    }

}