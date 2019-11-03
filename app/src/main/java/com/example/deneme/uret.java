package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class uret extends AppCompatActivity {

    ImageButton depo;
    ImageButton kulube;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    Button b_geri;


    int tas=0;
    int isci=0;
    int odun=0;
    int gun=0;

    //region Göstergelerin Yazdırıldığı Fonksiyon
    public void g_yaz(TextView g,int sayi){
        g.setText(String.valueOf(sayi));
    }
//endregion


    //region Yapı yapma fonksiyonu
    public boolean yap(int i)
    {
        if (yapilar.yapi[i][3]!=1 && yapilar.yapi[i][4]==0)
            if(yapilar.yapi[i][0]<=odun && yapilar.yapi[i][1]<=tas)
            {
                odun -=yapilar.yapi[i][0];
                tas -=yapilar.yapi[i][1];
                yapilar.yapi[i][4]++;
                g_yaz(g_odun,odun);
                g_yaz(g_tas,tas);
                return true;
            }
            else
                Toast.makeText(uret.this,"Yetersiz Kaynak",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(uret.this,"Bu yapı önceden yapılmış yada şuanda kilitli.",Toast.LENGTH_SHORT).show();
   return false;
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uret);

        kulube= findViewById(R.id.kucukkulube);
        depo=findViewById(R.id.depo);
        b_geri=findViewById(R.id.b_geri);

        g_odun=findViewById(R.id.g_odun);
        g_isci=findViewById(R.id.g_isci);
        g_tas=findViewById(R.id.g_tas);
        g_gun=findViewById(R.id.g_gun);

        //region Verilerin Alınıp Yazdırılması
        odun=kaynaklar.odun;
        isci=kaynaklar.isci;
        gun=kaynaklar.gun;
        tas=kaynaklar.tas;

        g_yaz(g_odun,odun);
        g_yaz(g_tas,tas);
        g_yaz(g_isci,isci);
        g_yaz(g_gun,gun);
        //endregion

        //region kulube butonu
        kulube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(yap(0))
                   yapilar.yapi[1][3]=0;
            }
        });
        //endregion

        // region Geri Butonu
        b_geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anaekran=new Intent(uret.this, anaekran.class);

                kaynaklar.odun=odun;
                kaynaklar.isci=isci;
                kaynaklar.tas=tas;
                kaynaklar.gun=gun;
                startActivity(anaekran);
            }
        });
//endregion

        //region Depo Butonu
        depo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(yap(1))
               {
                   kaynaklar.modun+=30;
                   kaynaklar.mtas +=30;
               }
            }
        });

//endregion

    }
}
