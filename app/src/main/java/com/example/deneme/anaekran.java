package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.view.ViewGroup;


public class anaekran extends AppCompatActivity {

    Button b_odun;
    Button b_topla;
    Button b_uret;
    Button b_atolye;
    Button cheat;
    Button b_uyu;
    Button b_bekle;
    Button b_maden;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    ProgressBar zaman;

    int tas = kaynaklar.tas;
    int mtas = kaynaklar.mtas;
    int isci = kaynaklar.isci;
    int odun = kaynaklar.odun;
    int modun = kaynaklar.modun;
    int gun = kaynaklar.gun;
    int g_zaman = kaynaklar.g_zaman;

    Timer tiktak = new Timer();
    Handler handler = new Handler();


    //region Timer Çalıştırdığı İşlemler
    TimerTask tik = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    odun += isci;
                    if (odun > modun)
                        odun = modun;
                    g_yaz(g_odun, odun, modun);
                }
            });
        }
    };
    //endregion
    //region Göstergelerin Yazdırıldığı Fonksiyon
    public void g_yaz(TextView g, int sayi, int maks) {
        if (maks != 0)
            g.setText(String.valueOf(sayi) + "/" + String.valueOf(maks));
        else
            g.setText(String.valueOf(sayi));
    }
//endregion
    //region Zaman ekleme gösterme fonksiyonu
    public void g_zaman(int s, char m) {
        if (m == 'a')
            g_zaman += s;
        else
            g_zaman = s;
        zaman.setProgress(g_zaman);
        if (g_zaman < 5)
            zaman.getProgressDrawable().setColorFilter(Color.parseColor("#ffec1e"), PorterDuff.Mode.SRC_IN);
        else if (g_zaman > 4 && g_zaman < 11)
            zaman.getProgressDrawable().setColorFilter(Color.parseColor("#fdc573"), PorterDuff.Mode.SRC_IN);
        else if (g_zaman > 10 && g_zaman < 14)
            zaman.getProgressDrawable().setColorFilter(Color.parseColor("#9b765c"), PorterDuff.Mode.SRC_IN);
        else
            zaman.getProgressDrawable().setColorFilter(Color.parseColor("#42423e"), PorterDuff.Mode.SRC_IN);
        if (g_zaman > 15) {
            g_zaman = 1;
            gun++;
            g_yaz(g_gun, gun, 0);
            zaman.setProgress(g_zaman);
            g_zaman(0, 'a');
        }
    }

    //endregion
    //region Checkunlocks
    void checkunlocks() {
        if (unlocks.atolye == 1)
            b_atolye.setVisibility(View.INVISIBLE);
        else
            b_atolye.setVisibility(View.VISIBLE);
        if (unlocks.atolye == 1)
            b_atolye.setVisibility(View.INVISIBLE);
        else
            b_atolye.setVisibility(View.VISIBLE);
        if (unlocks.balta == 1)
            b_odun.setVisibility(View.INVISIBLE);
        else
            b_odun.setVisibility(View.VISIBLE);
        if (unlocks.maden == 1)
            b_maden.setVisibility(View.INVISIBLE);
        else
            b_maden.setVisibility(View.VISIBLE);

        tas = kaynaklar.tas;
        mtas = kaynaklar.mtas;
        isci = kaynaklar.isci;
        odun = kaynaklar.odun;
        modun = kaynaklar.modun;
        gun = kaynaklar.gun;
        g_zaman = kaynaklar.g_zaman;
        g_yaz(g_odun, odun, modun);
        g_yaz(g_tas, tas, mtas);
        g_yaz(g_gun, gun, 0);
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);

//region id bağdaştırımı
        b_topla = findViewById(R.id.b_topla);
        b_odun = findViewById(R.id.b_odun);
        b_maden = findViewById(R.id.b_maden);
        cheat = findViewById(R.id.cheat);
        b_uret = findViewById(R.id.b_uret);
        b_uyu = findViewById(R.id.b_uyu);
        b_bekle = findViewById(R.id.b_bekle);
        b_atolye = findViewById(R.id.b_atolye);
        g_odun = findViewById(R.id.g_odun);
        g_isci = findViewById(R.id.g_isci);
        g_tas = findViewById(R.id.g_tas);
        g_gun = findViewById(R.id.g_gun);

        zaman = findViewById(R.id.progressBar);
//endregion

        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                odun = kaynaklar.modun;
                tas = kaynaklar.mtas;
                g_yaz(g_odun, odun, modun);
                g_yaz(g_tas, tas, mtas);
                WarriorStat wrr = new WarriorStat();
                goblin g = new goblin();
                fight a = new fight();
               String enemy = a.War(wrr,g,1);
               Log.v("enemy",enemy);

            }
        });

//region Butonların Kapalı Olması
        if (unlocks.atolye == 1)
            b_atolye.setVisibility(View.INVISIBLE);
        if (unlocks.balta == 1)
            b_odun.setVisibility(View.INVISIBLE);
        if (unlocks.maden == 1)
            b_maden.setVisibility(View.INVISIBLE);
        //endregion

//region Başlangıç Yazdrımı
        g_yaz(g_odun, odun, modun);
        g_yaz(g_tas, tas, mtas);
        g_yaz(g_gun, gun, 0);
//endregion

//region Zaman ilk atamaları
        zaman.setMax(15);
        zaman.setProgress(g_zaman);
        //endregion

//region Timer Parametreleri ve Başlatıcısı
        tiktak.schedule(tik, 1000, 3000);
//endregion

//region Topla Butonu
        b_topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (g_zaman + 1 < 13) {
                    Random rand = new Random();
                    tas += rand.nextInt(2) + 1;
                    odun += rand.nextInt(1) + 1;
                    if (odun > modun)
                        odun = modun;
                    if (tas > mtas)
                        tas = mtas;
                    g_zaman(1, 'a');
                    g_yaz(g_odun, odun, modun);
                    g_yaz(g_tas, tas, mtas);
                } else {
                    Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //endregion

//region Odun Kes Butonu
        b_odun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (g_zaman + 3 < 13) {
                    Random random = new Random();
                    odun += random.nextInt(5) + 3;
                    if (odun > modun)
                        odun = modun;
                    g_zaman(3, 'a');
                    g_yaz(g_odun, odun, modun);
                } else
                    Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();

            }
        });

//endregion

// region Uyu Butonu
        b_uyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g_zaman(16, 'a');
            }
        });
        //endregion

//region Üret Menü Butonu
        b_uret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uret = new Intent(anaekran.this, uret.class);
                kaynaklar.odun = odun;
                kaynaklar.isci = isci;
                kaynaklar.tas = tas;
                kaynaklar.gun = gun;
                kaynaklar.g_zaman = g_zaman;
                startActivity(uret);
            }
        });

//endregion

//region Bekle butonu
        b_bekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g_zaman(14, 's');
            }
        });
//endregion

//region Atölye Butonu
        b_atolye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atolye = new Intent(anaekran.this, atolye.class);
                startActivity(atolye);
                g_yaz(g_odun, odun, modun);
                g_yaz(g_tas, tas, mtas);
            }
        });
//endregion

//region Maden Butonu
        b_maden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           if(unlocks.q1i==1)
           {
               Toast.makeText(anaekran.this,"Maden Goblinler Tarafından saldırıya uğramış İlk Önce onları Öldürmen lazım",Toast.LENGTH_SHORT) .show();
               unlocks.q1i=0;
           }
           else
           {
               if (unlocks.kilic==1)
               {
                   Toast.makeText(anaekran.this,"İlk Önce Kılıç Yap",Toast.LENGTH_SHORT) .show();
               }
               else
               {
                   Intent i=new Intent(anaekran.this,dovusdeneme.class);
                   startActivity(i);
               }
           }
            }
        });
//endregion
    }

    public void onResume() {
        super.onResume();
        checkunlocks();
    }
}