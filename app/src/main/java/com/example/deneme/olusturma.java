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
                if (isim.getText().toString().trim().length() > 2) {
                karakter.sinif = r_sinif.getCheckedRadioButtonId();
                karakter.isim = isim.getText().toString();

                if (war.isChecked())
                    karakter.stat[0] +=2;

                else if (asa.isChecked())
                    karakter.stat[1]+=2;

                else
                    karakter.stat[2]+=2;

                Intent anaekran = new Intent(olusturma.this, stat.class);
                karakter.point=3;
                startActivity(anaekran);
            }else if(isim.getText().toString().equals("A"))
                {
                    //region Admin Mod
                    karakter.isim = isim.getText().toString();
                    karakter.sinif = r_sinif.getCheckedRadioButtonId();
                    yapilar.yapi[1][3]=0;
                    yapilar.yapi[2][3]=0;
                    unlocks.kk=0;
                    yapilar.yapi[3][3] = 0;
                    unlocks.ev = 0;
                    unlocks.atolye=0;
                    unlocks.balta=0;
                    unlocks.kilic=0;
                    unlocks.maden=0;
                    kaynaklar.mtas=9999;
                    kaynaklar.modun=9999;
                    kaynaklar.dtas=9999;
                    kaynaklar.cubuk=9999;
                    kaynaklar.tahta=9999;
                    Intent anaekran = new Intent(olusturma.this, stat.class);
                    karakter.point=0;
                    startActivity(anaekran);
                    //endregion

                }
                else
                Toast.makeText(olusturma.this,"İsiminiz Minimum 3 karakterden oluşmalı",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
