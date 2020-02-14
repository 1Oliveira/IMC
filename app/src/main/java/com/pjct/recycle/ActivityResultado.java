package com.pjct.recycle;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ActivityResultado extends AppCompatActivity {

    TextView tvResultado, tvFinal;
    float altura, peso;
    int spnSexo;
    ImageView imageMF;
    View viewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvFinal = findViewById(R.id.tvFinal);
        imageMF = findViewById(R.id.imageMF);
        viewResultado = findViewById(R.id.viewResultado);

        Bundle dados = getIntent().getExtras();
        altura = dados.getFloat("altura");
        peso = dados.getFloat("peso");
        spnSexo = dados.getInt("spnData");
        alteraResultado();

        if (spnSexo==1){
            trocaMasculino();
        }else if (spnSexo==2){
            trocaFeminino();
        }else{
            Toast.makeText(this,"Sexo não selecionado",Toast.LENGTH_SHORT).show();
            finish();
        }

    }
    private void alteraResultado() {
        float imc = calcularIMC(peso, altura);
        DecimalFormat df = new DecimalFormat("0.00");
        tvFinal.setText("IMC: " + df.format(imc));
    }

    public float calcularIMC(float peso, float altura) {
        return peso / (altura * altura);
    }

    public void trocaFeminino() {
        imageMF.setImageResource(R.drawable.femenino);
        int cor = Color.argb(15, 255, 38, 186);
        viewResultado.setBackgroundColor(cor);
    }

    public void trocaMasculino() {
        int cor = Color.argb(15, 0, 44, 255);
        viewResultado.setBackgroundColor(cor);
    }
}