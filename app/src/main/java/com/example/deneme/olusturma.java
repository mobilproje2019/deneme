package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class olusturma extends AppCompatActivity {

    Button olustur;
    EditText isim;
    RadioButton war,asa,mag;
    RadioGroup r_sinif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olusturma);

        olustur=findViewById(R.id.okey);
        isim=findViewById(R.id.isim);
        war=findViewById(R.id.m0);
        asa=findViewById(R.id.m1);
        mag=findViewById(R.id.m2);
        r_sinif=findViewById(R.id.r_sinif);



        olustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isim.getText().toString().trim().length() > 3) {
                karakter.sinif = r_sinif.getCheckedRadioButtonId();
                karakter.isim = isim.getText().toString();

                if (war.isChecked())
                    karakter.stat[0]++;

                else if (asa.isChecked())
                    karakter.stat[1]++;

                else
                    karakter.stat[2]++;

                Intent anaekran = new Intent(olusturma.this, stat.class);
                karakter.point=3;
                startActivity(anaekran);
            }
                else
                Toast.makeText(olusturma.this,"İsiminiz Minimum 3 karakterden oluşmalı",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
