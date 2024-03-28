package com.dbz.aguinaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class result_proporcional extends AppCompatActivity {

    TextView txtViewSalarioMensual, txtViewAguinaldo, txtViewDiasLaborados;
    String salarioMensual, diasLaborados, aguinaldo;
    double salario, sueldoDiario, proporcional, aguinaldoProporcional;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_proporcional);

        txtViewSalarioMensual = findViewById(R.id.txtViewSalarioMensual);
        txtViewDiasLaborados = findViewById(R.id.txtViewDiasLaborados);

        txtViewAguinaldo = findViewById(R.id.txtViewAguinaldo);

        Bundle obtenerData = getIntent().getExtras();
        assert obtenerData != null;

        salarioMensual = obtenerData.getString("salario");
        diasLaborados = obtenerData.getString("diasLaborados");

        assert salarioMensual != null;

        sueldoDiario = Double.parseDouble(salarioMensual) / 30;

        proporcional = sueldoDiario * 15;

        aguinaldoProporcional = proporcional / 365;

        salario = aguinaldoProporcional * Double.parseDouble(diasLaborados);
        aguinaldo = salario + "$";


        txtViewAguinaldo.setText(String.valueOf(aguinaldo));
        txtViewSalarioMensual.setText(salarioMensual);
        txtViewDiasLaborados.setText(diasLaborados);

    }

    public void irPantallaData(View v) {
        Intent lanzar = new Intent(this, DataAguinaldo.class);
        startActivity(lanzar);
        finish();

    }

    public void salir(View v) {
        finish();
    }
}