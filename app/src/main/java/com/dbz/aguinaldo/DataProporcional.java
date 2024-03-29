package com.dbz.aguinaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataProporcional extends AppCompatActivity {
    EditText txtsalarioMensual, txtDiasLaborados;
    String salarioMensual, diasLaborados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_proporcional);

        txtsalarioMensual = findViewById(R.id.txtEditSalarioMensual);
        txtDiasLaborados = findViewById(R.id.txtEditDiasLaborados);
    }

    public void calcularAguinaldo(View v) {
        salarioMensual = txtsalarioMensual.getText().toString();
        diasLaborados = txtDiasLaborados.getText().toString();

        if (salarioMensual.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su salario mensual", Toast.LENGTH_SHORT).show();
        } else if (diasLaborados.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese el numero de dias que ha laborado", Toast.LENGTH_SHORT).show();

        } else{
            Intent enviaraResult = new Intent(DataProporcional.this, result_proporcional.class);
            enviaraResult.putExtra("salario", salarioMensual);
            enviaraResult.putExtra("diasLaborados", diasLaborados);

            startActivity(enviaraResult);
            finish();
        }

    }

    public void irPantallaOpciones(View v) {
        Intent lanzar = new Intent(this, Options.class);
        startActivity(lanzar);
        finish();
    }
}