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

    TextView tvResultado, tvFinal,tvL1,tvL2,tvL3,tvL4,tvL5,tvL6;
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
        tvL1 = findViewById(R.id.tvL1);
        tvL2 = findViewById(R.id.tvL2);
        tvL3 = findViewById(R.id.tvL3);
        tvL4 = findViewById(R.id.tvL4);
        tvL5 = findViewById(R.id.tvL5);
        tvL6 = findViewById(R.id.tvL6);

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
        if (Float.compare(imc,18f)<=0){
            tvL1.setBackgroundColor(Color.rgb(252, 161, 40));
            tvFinal.setTextColor(Color.rgb(252, 161, 40));
        } else if (Float.compare(imc, 18.5f) > 0  &&  Float.compare(imc, 24.9f) <= 0) {
            tvL2.setBackgroundColor(Color.rgb(0, 161, 0));
            tvFinal.setTextColor(Color.rgb(0, 161, 0));
        } else if (Float.compare(imc, 25f) > 0  &&  Float.compare(imc, 29.9f) <= 0) {
            tvL3.setBackgroundColor(Color.rgb(252, 161, 40));
            tvFinal.setTextColor(Color.rgb(252, 161, 40));
        } else if (Float.compare(imc, 30f) > 0  &&  Float.compare(imc, 34.9f) <= 0) {
            tvL4.setBackgroundColor(Color.rgb(252, 161, 40));
            tvFinal.setTextColor(Color.rgb(252, 161, 40));
        } else if (Float.compare(imc, 35f) > 0  &&  Float.compare(imc, 39.9f) <= 0) {
            tvL5.setBackgroundColor(Color.rgb(255, 0, 0));
            tvFinal.setTextColor(Color.rgb(255, 0, 0));
        } else {
            tvL6.setBackgroundColor(Color.rgb(255, 0, 0));
            tvFinal.setTextColor(Color.rgb(255, 0, 0));
        }


    }

    public float calcularIMC(float peso, float altura) {
        return peso / (altura * altura);
    }

    public void trocaFeminino() {
        imageMF.setImageResource(R.drawable.femenino);
        int cor = Color.argb(35, 255, 38, 186);
        viewResultado.setBackgroundColor(cor);
    }

    public void trocaMasculino() {
        int cor = Color.argb(35, 0, 44, 255);
        viewResultado.setBackgroundColor(cor);
    }
}