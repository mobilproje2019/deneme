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

    TextView isim,g_tur,dhp;
    ProgressBar g_hp;
    ListView list;
    ArrayAdapter<String> adapter;
    Button atak,yetenek;

    int d_seviye=1;
    int etki=0;
    int hp=karakter.hp;
    int dusmans= 1;
    int tur=1;
    int[] skill;
    int dusmansayisi=0;
    int [][] dusman;
    Boolean bitir=false;
    ArrayList<String> log;

//region Düşman vuruş

    public void dusmanvurus() {
        for (int i = 0; i < dusmans; i++) {
            Random rnd = new Random();
            Random rnd2=new Random();
            int ihtimal=rnd2.nextInt(10)+1;
            if(ihtimal<4 && karakter.pasif==1)
            {
                log.add("Saldırıdan Kurtuldun");
            }
            else {
                if (etki == 1) {
                    log.add("Düşman Son Saldırının Etkisinden Çıkamamış.");
                    etki=0;
                }
                else
                {
                    int hasar = rnd.nextInt(10 + d_seviye * 2) + 1 + d_seviye * 3;
                    log.add("Düşman " + String.valueOf(hasar) + " kadar hasar verdi.");
                    hp -= hasar;
                    if (hp <= 0) {
                        hp = 0;
                        kaybetme();
                    }
                }
            }
            if(etki==2)
            {
                log.add("Düşmanın yarası kanıyor.");
                dusman[dusmansayisi][0] -=8+karakter.stat[1]/2;
                if( dusman[dusmansayisi][0]>1)
                {
                    dusman[dusmansayisi][0]=0;
                }
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
    if( dusman[dusmansayisi][0]<1)
    {
        kazandın();
    }

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
       dusman[i][0] = com.example.deneme.dusman.dusman[tip][1] + seviye*2;
       dusman[i][1]=com.example.deneme.dusman.dusman[tip][2] + seviye*2;
       dusman[i][2]= com.example.deneme.dusman.dusman[tip][3];
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

        Bundle intent=getIntent().getExtras();
        if(intent!=null) {
            skill = intent.getIntArray("yetenek");
        }
//region Attack
        atak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hit = 0;
                Random rnd = new Random();
                if (karakter.pasif == 0){
                    if (karakter.hp / 100 * 15 > hp) {
                        hit = rnd.nextInt(karakter.stat[0] + 20) + 1 + karakter.stat[0] * 3 + (karakter.hp - hp) / 5;
                    }
            }
               else {
                   hit = rnd.nextInt(karakter.stat[0] + 20) + 1 + karakter.stat[0] * 3;
                }
                dusman[dusmansayisi][0] -= hit;
                log.add("Düşmana" + String.valueOf(hit) + " kadar hasar verdiniz");
                if (dusman[dusmansayisi][0] < 1) {
                    if (dusmansayisi != dusmans - 1)
                        dusmansayisi++;
                    else
                        kazandın();
                }
                goster();
                dusmanvurus();
            }
        });
        //endregion

        //region Yetenek
        yetenek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ytnk=new Intent(dovusdeneme.this,yetenek.class);
                ytnk.putExtra("tur",tur);
                startActivity(ytnk);
            }
        });
        //endregion


    }

    //region Kazanma
    public  void kazandın()
    {
        Toast.makeText(dovusdeneme.this,"Madendeki Goblinleri Yenerek Madeni Güvenli Bir Hale Getirdin ve Esirleri Kurtardın. İçlerinden Biri Demirci olduğunu söylüyor",Toast.LENGTH_SHORT).show();
        unlocks.q1=0;
        Intent intent=new Intent(this,anaekran.class);
        startActivity(intent);
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

    @Override
    protected void onResume() {
        super.onResume();
        if(kaynaklar.getYetenek(skill)!=null)
        {skill=kaynaklar.getYetenek(skill);
        //MAGE
        if(karakter.pasif==2) {
            if (skill[0] == 0) {
                log.add("İyileştirme Gücünü Kullandın.");
                hp+=50+(karakter.seviye*2+karakter.stat[2]);
                goster();
                dusmanvurus();
            }
            else if (skill[0] == 2) {
                log.add("Ateş Topu Gücünü Kullanarak Rakibi Yaktın.");
                dusman[dusmansayisi][0]-=80+(karakter.seviye*2+karakter.stat[2]);
                goster();
                dusmanvurus();
            }
            else if (skill[0] == 4) {
                log.add("Bilgenin Öfkesi ile rakibinin yaşam enerjisini kendine çektin.");
                dusman[dusmansayisi][0]-=100+(karakter.seviye*2+karakter.stat[2]);
                hp+=100+(karakter.seviye*2+karakter.stat[2]);
                goster();
                dusmanvurus();
            }
        }
        //ASSASSIN
        else if(karakter.pasif==1)
        {
            if (skill[0] == 0) {
                log.add("Rakibe Bir Hançer Fırlattın.");
                dusman[dusmansayisi][0]-=50+(karakter.seviye*2+karakter.stat[1]);
                dusmanvurus();
                goster();
            }
            else if (skill[0] == 2) {
                log.add("Rakibin Zayıf noktasına vurarak 1 tur boyunca sana saldıramaz hale getirdin.");
                dusman[dusmansayisi][0]-=80+(karakter.seviye*2+karakter.stat[1]);
                etki=1;
                dusmanvurus();
                goster();
            }
            else if (skill[0] == 4) {
                log.add("Gölgenin Hançerini Düşmana Saplayarak Ağır Yaraya sebep oldun.");
                dusman[dusmansayisi][0]-=50+(karakter.seviye*2+karakter.stat[1]);
                hp+=60+(karakter.seviye*2+karakter.stat[2]);
                etki=2;

                dusmanvurus();
                goster();
            }
        }
        //Warrior
            else
        {
            if (skill[0] == 0) {
                log.add("Ağır Darbe Yeteneğiyle Düşmanı 1 Tur Etkisiz Kıldın.");
                dusman[dusmansayisi][0]-=100+(karakter.seviye*2+karakter.stat[0]);
                etki=1;
                dusmanvurus();
                goster();
            }
            else if (skill[0] == 2) {
                log.add("Saf Gücünle Düşmana Atıldın.");
                dusman[dusmansayisi][0]-=120+(karakter.seviye*2+karakter.stat[0]);
                dusmanvurus();
                goster();
            }
            else if (skill[0] == 4) {
                log.add("Kafa Kıran Darbesiyle Düşmana Ağır Hasar Verdin.");
                dusman[dusmansayisi][0]-=200+(karakter.seviye*2+karakter.stat[0]);
                dusmanvurus();
                goster();
            }

        }

        }

    }
}
