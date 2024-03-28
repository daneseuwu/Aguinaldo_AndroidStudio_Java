package com.dbz.aguinaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class result_aguinaldo extends AppCompatActivity {

    TextView txtViewSalarioMensual, txtViewAguinaldo, txtViewAniosLaborados;
    String salarioMensual, aniosLaborales, aguinaldo;
    double sueldoDiario, anios, salaraio2, salaraio3, salaraio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_aguinaldo);

        txtViewSalarioMensual = findViewById(R.id.txtViewSalarioMensual);
        txtViewAniosLaborados = findViewById(R.id.txtViewDiasLaborados);

        txtViewAguinaldo = findViewById(R.id.txtViewAguinaldo);

        Bundle obtenerData = getIntent().getExtras();
        assert obtenerData != null;

        salarioMensual = obtenerData.getString("salario");
        aniosLaborales = obtenerData.getString("aniosLaborados");

        assert salarioMensual != null;

        //sacar salario diario
        sueldoDiario = Double.parseDouble(salarioMensual) / 30;

        anios = Double.parseDouble(aniosLaborales);

        if(anios ==1 ){
            salaraio2 = Double.parseDouble(salarioMensual) / 30 * 15;
            aguinaldo = salaraio2 + "$";
        } else if (anios >= 1 && anios <= 3) {
            // Entre 1 y 3 años	        15 Días de Salario

            salaraio2 = Double.parseDouble(salarioMensual) / 30 * 15;
            aguinaldo = salaraio2 + "$";

        } else if (anios >= 3 && anios < 10) {

            //Entre 3 y 10 años	      19 Días de Salario

            salaraio3 = Double.parseDouble(salarioMensual) / 30 * 19;
            aguinaldo = salaraio3 + "$";


        } else if (anios >= 10) {
            // 10 o mas años	          21 Días de Salario

            salaraio4 = Double.parseDouble(salarioMensual) / 30 * 21;
            aguinaldo = salaraio4 + "$";

        } else {
            aguinaldo = "Dato no valido";
        }

        txtViewSalarioMensual.setText(salarioMensual);
        txtViewAguinaldo.setText(String.valueOf(aguinaldo));
        txtViewAniosLaborados.setText(aniosLaborales);
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