package com.pjct.recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public Button btCalcular;
    public SeekBar sbPeso;
    public SeekBar sbAltura;
    public TextView tvPeso, tvAltura, tvValorPeso, tvValorAltura;
    public float altura, peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbPeso = findViewById(R.id.sbPeso);
        sbAltura = findViewById(R.id.sbAltura);
        btCalcular = findViewById(R.id.btCalcular);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvValorAltura = findViewById(R.id.tvValorAltura);
        tvValorPeso = findViewById(R.id.tvValorPeso);

        sbPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                peso = i;
                mostraValor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                altura= (float) ((float) i/10.0);
                mostraValor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
                intent.putExtra("altura",altura);
                intent.putExtra("peso",peso);

                startActivity(intent);

            }
        });
    }
    void mostraValor(){
        tvValorPeso.setText(peso+" Kg");
        DecimalFormat df = new DecimalFormat("0.00");
        tvValorAltura.setText(df.format(altura)+" m");
    }

}
