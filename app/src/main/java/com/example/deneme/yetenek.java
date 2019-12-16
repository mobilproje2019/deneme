package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class yetenek extends AppCompatActivity {

    ImageView skill1,skill2,skill3;
    ImageView pasif;
    TextView g_skill1,g_skill1ac,g_skill2,g_skill2ac,g_skill3,g_skill3ac,g_pasif,pasifac;
    int[] cd={karakter.skills[0][4],karakter.skills[1][4],karakter.skills[2][4]};
    int[] cdorj={karakter.skills[0][4],karakter.skills[1][4],karakter.skills[2][4]};
    int tur=0;
    Yetenekler yetenekler = new Yetenekler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yetenek);

        yetenekler.initcharacter(karakter.pasif);
    //region ID Tanımlamaları
        pasif=findViewById(R.id.pasif);
        skill1=findViewById(R.id.skill1);
        skill1=findViewById(R.id.skill1);
        skill2=findViewById(R.id.skill2);
        skill3=findViewById(R.id.skill3);

        g_pasif=findViewById(R.id.g_pasif);
        pasifac=findViewById(R.id.pasifac);
        g_skill1=findViewById(R.id.g_skill1);
        g_skill1ac=findViewById(R.id.g_skill1ac);
        g_skill2=findViewById(R.id.g_skill2);
        g_skill2ac=findViewById(R.id.g_skill2ac);
        g_skill3=findViewById(R.id.g_skill3);
        g_skill3ac=findViewById(R.id.g_skill3ac);

        pasif.setImageResource(karakter.resimler[karakter.pasif][0]);
        skill1.setImageResource(karakter.resimler[karakter.pasif][1]);
        skill2.setImageResource(karakter.resimler[karakter.pasif][2]);
        skill3.setImageResource(karakter.resimler[karakter.pasif][3]);

       g_pasif.setText(yetenekler.getPassiveName());
       pasifac.setText(yetenekler.getPassive());
       g_skill1.setText(yetenekler.getSkill_1Name());
       g_skill1ac.setText(yetenekler.getSkill_1());
       g_skill2.setText(yetenekler.getSkill_2Name());
       g_skill2ac.setText(yetenekler.getSkill_2());
       g_skill3.setText(yetenekler.getSkill_3Name());
       g_skill3ac.setText(yetenekler.getSkill_3());

//endregion
       Bundle intent=getIntent().getExtras();
       if(intent!=null)
       tur=intent.getInt("tur");

       //region Yazı veya reismin üstüne basınca

       g_skill1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               skill1();
           }
       });

       skill1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               skill1();
           }
       });

       g_skill2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               skill2();
           }
       });

       skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill2();
            }
        });

        g_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill3();
            }
        });

       skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill3();
            }
        });
        //endregion

    }


    public void skill1()
    {
        if(tur<yetenekler.k[0])
        {
            Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
        }
        else {
            yetenekler.k[0]=cdorj[0]+tur;
            int[] yetenek = new int[karakter.skills[1].length];
            for (int i = 0; i < karakter.skills[1].length; i++) {
                yetenek[i] = karakter.skills[0][i];
            }
            kaynaklar.setYetenek(yetenek);
            finish();
        }
    }
    public void skill2()
    {
    if(karakter.seviye<karakter.skills[1][0])
    {
        Toast.makeText(yetenek.this, "Bu Yetenek için"+karakter.skills[1][0] +"seviye olmalısınız.", Toast.LENGTH_SHORT).show();
    }
    else {
        if (tur<yetenekler.k[1]) {
            Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
        } else {
                yetenekler.setSkill_2CD(cdorj[1]+tur);
            int[] yetenek = new int[karakter.skills[1].length];
            for (int i = 0; i < karakter.skills[1].length; i++) {
                yetenek[i] = karakter.skills[1][i];
            }

            kaynaklar.setYetenek(yetenek);
            finish();
        }
    }
    }
    public void skill3()
    {
        if(karakter.seviye<karakter.skills[2][0])
        {
            Toast.makeText(yetenek.this, "Bu Yetenek için"+karakter.skills[2][0] +"seviye olmalısınız.", Toast.LENGTH_SHORT).show();
        }
    else {
            if (tur<yetenekler.k[2]) {
                Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
            } else {
                yetenekler.setSkill_3CD(cdorj[2]+tur);
                int[] yetenek = new int[karakter.skills.length];
                for (int i = 0; i < karakter.skills.length; i++) {
                    yetenek[i] = karakter.skills[2][i];
                }

                kaynaklar.setYetenek(yetenek);
                finish();
            }
        }
    }

}
