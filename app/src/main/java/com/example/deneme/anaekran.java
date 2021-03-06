package com.example.deneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class anaekran extends AppCompatActivity {

    MediaPlayer medya,medya2;

    //region Butonlar , TetxViewlar
    Button b_odun;
    Button b_topla;
    Button b_uret;
    Button b_atolye;
    Button b_info;
    Button cheat;
    Button b_maden;
    Button b_sehir;
    Button fight;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    Button b_demirci;
    //endregion
    public static ConstraintLayout nesne;

    int tas = kaynaklar.tas;
    int maxtas = kaynaklar.maxtas;
    int isci = kaynaklar.isci;
    int odun = kaynaklar.odun;
    int maxodun = kaynaklar.maxodun;
    int gun = kaynaklar.gun;
    int g_zaman = kaynaklar.g_zaman;
    boolean a = false;
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
                    if (odun > maxodun)
                        odun = maxodun;
                    g_yaz(g_odun, odun, maxodun);
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
        if (unlocks.kopru == 1)
            b_sehir.setVisibility(View.INVISIBLE);
        else
            b_sehir.setVisibility(View.VISIBLE);
        if(karakter.isim.equals("a") || karakter.isim.equals("A"))
            cheat.setVisibility(View.VISIBLE);
        else
            cheat.setVisibility(View.INVISIBLE);
        if(unlocks.demirci==0)
        {
            b_demirci.setVisibility(View.VISIBLE);
        }
        if (unlocks.kk == 0)
        {
            nesne.setBackgroundResource(R.drawable.m2);
            if(yapilar.yapi[1][4]>0)
            {
                nesne.setBackgroundResource(R.drawable.m21);
            }
            if(unlocks.ev==0)
                nesne.setBackgroundResource(R.drawable.m3);
            if(unlocks.demirci==0)
                nesne.setBackgroundResource(R.drawable.m4);
        }
        tas = kaynaklar.tas;
        maxtas = kaynaklar.maxtas;
        isci = kaynaklar.isci;
        odun = kaynaklar.odun;
        maxodun = kaynaklar.maxodun;
        gun = kaynaklar.gun;
        g_zaman = kaynaklar.g_zaman;
        g_yaz(g_odun, odun, maxodun);
        g_yaz(g_tas, tas, maxtas);
        g_yaz(g_gun, gun, 0);
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);

    //region id bağdaştırımı
        fight=findViewById(R.id.btndovus);
        b_info=findViewById(R.id.b_info);
        b_demirci=findViewById(R.id.demirci);
        b_topla = findViewById(R.id.b_topla);
        b_sehir = findViewById(R.id.sehir);
        b_odun = findViewById(R.id.b_odun);
        b_maden = findViewById(R.id.b_maden);
        cheat = findViewById(R.id.cheat);
        b_uret = findViewById(R.id.b_uret);
        b_atolye = findViewById(R.id.b_atolye);
        g_odun = findViewById(R.id.g_odun);
        g_isci = findViewById(R.id.g_isci);
        g_tas = findViewById(R.id.g_tas);
        g_gun = findViewById(R.id.g_gun);
        nesne=findViewById(R.id.back);
//endregion
    //region DEBUG Butonu
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a) {
                    a = true;
                    yapilar.yapi[1][3] = 0;
                    yapilar.yapi[2][3] = 0;
                    unlocks.kk = 0;
                    yapilar.yapi[3][3] = 0;
                    yapilar.yapi[4][3] = 0;
                    unlocks.ev = 0;
                    unlocks.atolye = 0;
                    unlocks.balta = 0;
                    unlocks.kilic = 0;
                    unlocks.maden = 0;
                    unlocks.demirci = 0;
                    unlocks.kopru = 0;
                    kaynaklar.maxtas = 9999;
                    kaynaklar.maxodun = 9999;
                    kaynaklar.dtas = 9999;
                    kaynaklar.cubuk = 9999;
                    kaynaklar.tahta = 9999;
                    karakter.seviye = 10;
                    fight.setVisibility(View.VISIBLE);
                    checkunlocks();
                }
                odun = kaynaklar.maxodun;
                tas = kaynaklar.maxtas;
                kaynaklar.odun=odun;
                kaynaklar.tas=tas;
                g_yaz(g_odun, odun, maxodun);
                g_yaz(g_tas, tas, maxtas);
            }
        });
//endregion
// region Başlangıç Yazdırımı
        g_yaz(g_odun, odun, maxodun);
        g_yaz(g_tas, tas, maxtas);
        g_yaz(g_gun, gun, 0);
//endregion
//region Timer Parametreleri ve Başlatıcısı
        tiktak.schedule(tik, 1000, 3000);
//endregion
//region Dovus Butonu
            fight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for ( int i=0;i<3;i++)
                        Yetenekler.k[i]=karakter.skills[i][4];
                    Intent i = new Intent(getApplicationContext(),dovusdeneme.class);
                    i.putExtra("dusmanhp",2000);
                    startActivity(i);
                }
            });

        //endregion
//region Topla Butonu
        b_topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Random rand = new Random();
                    tas += rand.nextInt(2) + 1;
                    odun += rand.nextInt(1) + 1;
                    if (odun > maxodun)
                        odun = maxodun;
                    if (tas > maxtas)
                        tas = maxtas;
                    g_yaz(g_odun, odun, maxodun);
                    g_yaz(g_tas, tas, maxtas);
            }
        });
        //endregion

//region Odun Kes Butonu
        b_odun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Random rnd=new Random();
                    Random random = new Random();
                    odun += random.nextInt(5) + 3;
                    if (odun > maxodun)
                        odun = maxodun;
                    g_yaz(g_odun, odun, maxodun);
                    kaynaklar.odun=odun;
                   medya=MediaPlayer.create(anaekran.this,sesler.odun[  rnd.nextInt(4)]);
                   medya.start();

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


//region Atölye Butonu
        b_atolye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atolye = new Intent(anaekran.this, atolye.class);
                kaynaklar.odun = odun;
                kaynaklar.isci = isci;
                kaynaklar.tas = tas;
                kaynaklar.gun = gun;
                g_yaz(g_odun, odun, maxodun);
                g_yaz(g_tas, tas, maxtas);
                startActivity(atolye);
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
                 //region GÖREV TAMAM DEĞİLSE
                   for ( int i=0;i<3;i++)
                       Yetenekler.k[i]=karakter.skills[i][4];
                   if(unlocks.q1 ==1){
                   Intent i=new Intent(anaekran.this,dovusdeneme.class);
                   startActivity(i);}
                 //endregion

                 //region Görev Tamalanmışsa
                   else
                   {
                       medya2= MediaPlayer.create(anaekran.this,R.raw.maden);
                       medya2.start();

                           Random random = new Random();
                           tas += random.nextInt(5) + 3;
                           if (tas > maxtas)
                               tas = maxtas;
                           g_yaz(g_tas, tas, maxtas);
                           kaynaklar.tas=tas;
                           medya2.release();
                   }
                   //endregion
               }
           }
            }
        });
//endregion
//region Demirci
            b_demirci.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (unlocks.kk == 0)
                    {
                        if(unlocks.demirci==0)
                        {
                            Intent i = new Intent(getApplicationContext(),demirci.class);
                            startActivity(i);
                        }
                    }
                }
            });
        //endregion
//region Şehir
        b_sehir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sehir=new Intent(anaekran.this,sehir.class);
                startActivity(sehir);
            }
        });
        //endregion

        //region İnfo
        b_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyCustomAlertDialog();
            }
        });
        //endregion

    }
public void showMyCustomAlertDialog()
{
    final Dialog dialog = new Dialog(anaekran.this);
    dialog.setContentView(R.layout.custom_info);
    ToggleButton i1 = dialog.findViewById(R.id.i1);
    ToggleButton i2=  dialog.findViewById(R.id.i2);
    final TextView i1t= (TextView) dialog.findViewById(R.id.i1t);
    final TextView i2t= (TextView) dialog.findViewById(R.id.i2t);

    i1t.setText("");
    i2t.setText("");

   i1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           if(isChecked)
           {
               i1t.setText(R.string.i1t);
           }
           else
           {
               i1t.setText("");
           }
       }
   });
i2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            i2t.setText(R.string.i2t);
        else
            i2t.setText("");
    }
});

    dialog.show();

}

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(anaekran.this);
        builder.setCancelable(false);
        builder.setMessage("Anamenüye dönmek istediğinize emin misiniz?");
        builder.setNegativeButton("Hayır", null);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent k=new Intent(anaekran.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
        builder.show();
    }


    public void onResume() {
        super.onResume();
        checkunlocks();
    }
}