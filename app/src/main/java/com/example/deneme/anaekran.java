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
    Button b_uyu;
    Button b_bekle;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    ProgressBar zaman;

    int tas=kaynaklar.tas;
    int mtas=30;
    int isci=kaynaklar.isci;
    int odun=kaynaklar.odun;
    int modun=60;
    int gun=kaynaklar.gun;
    int g_zaman=1;

    Timer tiktak = new Timer();
    Handler handler=new Handler();


    //region Timer Çalıştırdığı İşlemler
    TimerTask tik= new TimerTask() {
        @Override
        public void run() {
    handler.post(new Runnable() {
    @Override
    public void run() {
        odun+=isci;
        if(odun>modun)
            odun=modun;
        g_yaz(g_odun,odun,modun);
    }
});
        }
    };
    //endregion

    //region Göstergelerin Yazdırıldığı Fonksiyon
public void g_yaz(TextView g,int sayi,int maks){
    if(maks!=0)
    g.setText(String.valueOf(sayi)+"/"+String.valueOf(maks));
else
        g.setText(String.valueOf(sayi));
}
//endregion

    //region Zaman ekleme gösterme fonksiyonu
public void g_zaman(int s,char m){
    if(m=='a')
        g_zaman+=s;
    else
        g_zaman=s;
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
    {g_zaman=1; gun++; g_yaz(g_gun,gun,0); zaman.setProgress(g_zaman); g_zaman(0,'a');}
}
//endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);



//region id bağdaştırımı
    b_topla=findViewById(R.id.b_topla);
    b_odun=findViewById(R.id.b_odun);
    b_uret=findViewById(R.id.b_uret);
    b_uyu=findViewById(R.id.b_uyu);
    b_bekle=findViewById(R.id.b_bekle);

    g_odun=findViewById(R.id.g_odun);
    g_isci=findViewById(R.id.g_isci);
    g_tas=findViewById(R.id.g_tas);
    g_gun=findViewById(R.id.g_gun);

    zaman=findViewById(R.id.progressBar);
//endregion

//region Başlangıç Yazdrımı
        g_yaz(g_odun,odun,modun);g_yaz(g_tas,tas,mtas);g_yaz(g_gun,gun,0);
//endregion

//region Zaman ilk atamaları
    zaman.setMax(15);
    zaman.setProgress(g_zaman);
    //endregion

//region Timer Parametreleri ve Başlatıcısı
    tiktak.schedule(tik,1000,3000);
//endregion

//region Topla Butonu
    b_topla.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           if(g_zaman+1<13){
            Random rand=new Random();
            tas+=rand.nextInt(2)+1;
            odun+=rand.nextInt(1)+1;
            if(odun>modun)
                odun=modun;
            if(tas>mtas)
                tas=mtas;
            g_zaman(1,'a');
            g_yaz(g_odun,odun,modun);
            g_yaz(g_tas,tas,mtas);
        }
           else
           {
               Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();
           }
        }
    });
    //endregion

//region Odun Kes Butonu
    b_odun.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(g_zaman+3<13){
                Random random=new Random();
            odun+=random.nextInt(5)+3;
            if(odun>modun)
                odun=modun;
            g_zaman(3,'a');
            g_yaz(g_odun,odun,modun);
            }
        else
            Toast.makeText(anaekran.this, "Daha Fazla Çalışamazsın Lütfen Uyu", Toast.LENGTH_SHORT).show();

        }
    });

//endregion

// region Uyu Butonu
        b_uyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g_zaman(16,'a');
            }
        });
        //endregion

//region Üret Menü Butonu
    b_uret.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
    Intent uret=new Intent(anaekran.this,uret.class);
    int[] kaynak= {odun,tas,isci,gun};
    uret.putExtra("veri",kaynak);
    startActivity(uret);
        }
    });

//endregion

//region Bekle butonu
b_bekle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        g_zaman(14,'s');
    }
});
//endregion

    }
}
