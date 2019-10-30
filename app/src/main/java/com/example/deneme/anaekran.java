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
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    ProgressBar zaman;

    int tas=0;
    int isci=0;
    int odun=0;
    int gun=0;
    int g_zaman=0;

    Timer tiktak = new Timer();
    Handler handler=new Handler();


    // Timer Çalıştırığı İşlemler
    TimerTask tik= new TimerTask() {
        @Override
        public void run() {
    handler.post(new Runnable() {
    @Override
    public void run() {
        odun+=isci;
        g_yaz(g_odun,odun);
    }
});
        }
    };


    // Göstergelerin Yazdırıldığı Fonksiyon
public void g_yaz(TextView g,int sayi){
    g.setText(String.valueOf(sayi));
}

public void g_zaman(int s){
    g_zaman+=s;
    zaman.setProgress(g_zaman);
    if(g_zaman<5)
        zaman.getProgressDrawable().setColorFilter(Color.parseColor("#ffec1e"), PorterDuff.Mode.SRC_IN);
    else if(g_zaman>4&&g_zaman<11)
        zaman.getProgressDrawable().setColorFilter(Color.parseColor("#fdc573"), PorterDuff.Mode.SRC_IN);
    else if(g_zaman>10&&g_zaman<14)
        zaman.getProgressDrawable().setColorFilter(Color.parseColor("#9b765c"), PorterDuff.Mode.SRC_IN);
    else
        zaman.getProgressDrawable().setColorFilter(Color.parseColor("#42423e"), PorterDuff.Mode.SRC_IN);
    if(g_zaman>15)
    {g_zaman=0; gun++; g_yaz(g_gun,gun);}
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);
    b_topla=findViewById(R.id.b_topla);
    g_odun=findViewById(R.id.g_odun);
    b_odun=findViewById(R.id.b_odun);
    g_isci=findViewById(R.id.g_isci);
    b_uret=findViewById(R.id.b_uret);
    g_tas=findViewById(R.id.g_tas);
    g_gun=findViewById(R.id.g_gun);
    zaman=findViewById(R.id.progressBar);

    zaman.setMax(15);
    zaman.setProgress(g_zaman);

        //Timer Parametreleri ve Başlatıcısı
    tiktak.schedule(tik,1000,3000);

//Topla Butonu
    b_topla.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           if(g_zaman<13){
            Random rand=new Random();
            tas+=rand.nextInt(2)+1;
            odun+=rand.nextInt(1)+1;
g_zaman(1);
            g_yaz(g_odun,odun);
            g_yaz(g_tas,tas);
        }
           else
           {
               Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();
           }
        }
    });

//Odun Kes Butonu
    b_odun.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(g_zaman<13){
            odun++;
            g_zaman(3);
            g_yaz(g_odun,odun);
            }
        else
            Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();
        }
    });


    b_uret.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
    Intent uret=new Intent(anaekran.this,uret.class);
    startActivity(uret);
        }
    });

    }
}
