package com.pjct.recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityResultado extends AppCompatActivity {

    TextView tvResultado, tvFinal;
    float altura, peso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvFinal = findViewById(R.id.tvFinal);

        Bundle dados = getIntent().getExtras();
        altura = dados.getFloat("altura");
        peso = dados.getFloat("peso");
        alteraResultado();
    }
    private void alteraResultado() {
        float imc = calcularIMC(peso, altura);
        DecimalFormat df = new DecimalFormat("0.00");
        tvFinal.setText("IMC: "+df.format(imc));
    }
    public float calcularIMC(float peso, float altura) {
        return peso / (altura * altura);
    }
}
