package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class yetenek extends AppCompatActivity {

    ImageView skill1,skill2,skill3;
    ImageView pasif;
    TextView g_skill1,g_skill1ac,g_skill2,g_skill2ac,g_skill3,g_skill3ac,g_pasif,pasifac;


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

        pasif.setImageResource(karakter.resimler[karakter.pasif][1]);
        skill1.setImageResource(karakter.resimler[karakter.pasif][1]);
        skill2.setImageResource(karakter.resimler[karakter.pasif][1]);
        skill3.setImageResource(karakter.resimler[karakter.pasif][1]);

        g_pasif.setText(karakter.aciklama[karakter.pasif][0]);
        pasifac.setText(karakter.aciklama[karakter.pasif][1]);
        g_skill1.setText(karakter.aciklama[karakter.pasif][2]);
        g_skill1ac.setText(karakter.aciklama[karakter.pasif][3]);
        g_skill2.setText(karakter.aciklama[karakter.pasif][4]);
        g_skill2ac.setText(karakter.aciklama[karakter.pasif][5]);
        g_skill3.setText(karakter.aciklama[karakter.pasif][6]);
        g_skill3ac.setText(karakter.aciklama[karakter.pasif][7]);


    }
}
