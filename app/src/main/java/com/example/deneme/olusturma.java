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

                if (war.isChecked()) {
                    if(karakter.stat[0]<2&&karakter.stat[2]<2&&karakter.stat[1]<2){
                    karakter.stat[0] += 2;
                    }
                    karakter.pasif=0;
                    karakter.skills=karakter.warrior;
                }
                else if (asa.isChecked()){
                    if(karakter.stat[0]<2&&karakter.stat[2]<2&&karakter.stat[1]<2)
                karakter.stat[1]+=2;
                karakter.pasif=1;
                karakter.skills=karakter.assassin;
                }
                else {
                    if(karakter.stat[0]<2&&karakter.stat[2]<2&&karakter.stat[1]<2)
                    karakter.stat[2] += 2;
                    karakter.pasif=2;
                    karakter.skills=karakter.mage;
                }
                Intent anaekran = new Intent(olusturma.this, stat.class);
                if(!karakter.olusturdu)
                karakter.point=3;
                else
                    karakter.point=0;
                    karakter.olusturdu=true;
                startActivity(anaekran);
            }else if(isim.getText().toString().equals("A") || isim.getText().toString().equals("a"))
                {
                    //region Admin Mod
                    karakter.isim = isim.getText().toString();
                    karakter.sinif = r_sinif.getCheckedRadioButtonId();

                    if(war.isChecked())
                    {
                        karakter.pasif=0;
                        karakter.skills=karakter.warrior;
                    }
                    if(asa.isChecked())
                    {
                        karakter.pasif=1;
                        karakter.skills=karakter.assassin;
                    }
                    if(mag.isChecked())
                    {
                        karakter.pasif=2;
                        karakter.skills=karakter.mage;
                    }

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
