package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dovusdeneme extends AppCompatActivity {

    LinearLayout layout;
    ScrollView scrollView;

    TextView isim,g_tur,dhp;
    ProgressBar g_hp;
    ListView list;
    ArrayAdapter<String> adapter;
    Button atak,yetenek;

    int d_seviye=1;
    int hp=karakter.hp;
    int dusmans= 1;
    int tur=1;
    int dusmansayisi=0;
    int [][] dusman;
    ArrayList<String> log;

//region Düşman vuruş

    public void dusmanvurus() {
        for (int i = 0; i < dusmans; i++) {
            Random rnd = new Random();

            int hasar = rnd.nextInt(10 + d_seviye * 2) + 1 + d_seviye * 3;

            log.add("Düşman "+String.valueOf(hasar)+" kadar hasar verdi.");
            hp -=hasar;
            if(hp<=0)
            {
                hp=0;

            }
            goster();
        }
        tur++;
    }

    //endregion

//region Göster
public void goster()
{
    isim.setText(karakter.isim);
    g_hp.setProgress(hp);
    if(log.size()>3)
    {
        log.remove(0);
    }
    g_tur.setText("Tur:"+tur);
    dhp.setText("Düşman:"+dusman[dusmansayisi][0]);
    adapter.notifyDataSetChanged();



}
//endregion

//region Düşman Oluşması
    public void dusmanolustur(int sayi,int tip, int makslevel)
    {
       dusman=new int[sayi][3];        //hp , atak , skill tur
        for(int i=0;i<sayi;i++)
        {
            Random rnd =new Random();
        int seviye=rnd.nextInt(makslevel)+makslevel/2+1;
      // dusman[i][0] = com.example.deneme.dusman.dusman[tip][1] + seviye*2;
      // dusman[i][1]=com.example.deneme.dusman.dusman[tip][2] + seviye*2;
      // dusman[i][2]= com.example.deneme.dusman.dusman[tip][3];
        }
    }
//endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dovusdeneme);

        yetenek=findViewById(R.id.skill);
        g_tur = findViewById(R.id.tur);
        dhp = findViewById(R.id.dhp);
        list = findViewById(R.id.liste);
        log = new ArrayList<String>();
        isim = findViewById(R.id.g_ad);
        g_hp = findViewById(R.id.g_hp);
        atak = findViewById(R.id.b_attack);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, log);

        log.add(" ");
        log.add(" ");
        log.add(" ");

        list.setAdapter(adapter);

        dusmanolustur(1, 1, 5);

        goster();

//region Attack
        atak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int hit = rnd.nextInt(karakter.stat[0] + 20) + 1 + karakter.stat[0] * 3;
                dusman[dusmansayisi][0] -= hit;
                log.add("Düşmana" + String.valueOf(hit) + " kadar hasar verdiniz");
                dusmanvurus();
                if (dusman[dusmansayisi][0] < 1) {
                    if (dusmansayisi != dusmans - 1)
                        dusmansayisi++;
                    else
                        kazandın();
                }
                goster();
            }
        });
        //endregion
    }

    //region KAzanma
    public  void kazandın()
    {
        Toast.makeText(dovusdeneme.this,"Madendeki Goblinleri Yenerek Madeni Güvenli Bir Hale Getirdin ve Esirleri Kurtardın. İçlerinden Biri Demirci olduğunu söylüyor",Toast.LENGTH_SHORT).show();
        unlocks.q1=0;
    }
//endregion


    //region kaybeyme
    public void kaybetme()
    {
        Toast.makeText(dovusdeneme.this, "Kritik bir yara aldın fakat kaçmayı başardın", Toast.LENGTH_SHORT).show();
        Intent geridonus=new Intent(dovusdeneme.this,anaekran.class);
        startActivity(geridonus);
    }
    //endregion

}
