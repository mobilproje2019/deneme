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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yetenek);

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

       g_pasif.setText(karakter.aciklama[karakter.pasif][0]);
       pasifac.setText(karakter.aciklama[karakter.pasif][1]);
       g_skill1.setText(karakter.aciklama[karakter.pasif][2]);
       g_skill1ac.setText(karakter.aciklama[karakter.pasif][3]);
       g_skill2.setText(karakter.aciklama[karakter.pasif][4]);
       g_skill2ac.setText(karakter.aciklama[karakter.pasif][5]);
       g_skill3.setText(karakter.aciklama[karakter.pasif][6]);
       g_skill3ac.setText(karakter.aciklama[karakter.pasif][7]);


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
        if(tur<cd[0])
        {
            Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
        }
        else {
            cd[0] =tur+cdorj[0];
            int[] yetenek = new int[karakter.skills[1].length];
            for (int i = 0; i < karakter.skills[1].length; i++) {
                yetenek[i] = karakter.skills[0][i];
            }

            Intent skill = new Intent(yetenek.this, dovusdeneme.class);
            skill.putExtra("yetenek", yetenek);
            startActivity(skill);
        }
    }
    public void skill2()
    {
    if(karakter.seviye<karakter.skills[1][0])
    {
        Toast.makeText(yetenek.this, "Bu Yetenek için"+karakter.skills[1][0] +"seviye olmalısınız.", Toast.LENGTH_SHORT).show();
    }
    else {
        if (tur < cd[1]) {
            Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
        } else {
                cd[1] =tur+cdorj[1];
            int[] yetenek = new int[karakter.skills[1].length];
            for (int i = 0; i < karakter.skills[1].length; i++) {
                yetenek[i] = karakter.skills[1][i];
            }

            Intent skill = new Intent(yetenek.this, dovusdeneme.class);
            skill.putExtra("yetenek", yetenek);
            startActivity(skill);
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
            if (tur < cd[2]) {
                Toast.makeText(yetenek.this, "Henüz Hazır Değil", Toast.LENGTH_SHORT).show();
            } else {
                cd[2] =tur+cdorj[2];
                int[] yetenek = new int[karakter.skills.length];
                for (int i = 0; i < karakter.skills.length; i++) {
                    yetenek[i] = karakter.skills[2][i];
                }

                Intent skill = new Intent(yetenek.this, dovusdeneme.class);
                skill.putExtra("yetenek", yetenek);
                startActivity(skill);
            }
        }
    }

}
