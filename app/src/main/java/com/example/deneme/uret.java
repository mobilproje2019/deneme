package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;

public class uret extends AppCompatActivity {

    ImageButton[] b_gosterge;
    TextView[] t_gosterge;

    ImageButton depo;
    ImageButton kulube;
    ImageButton ev;
    ImageButton atolye;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    Button b_geri;

    TextView t_depo;
    TextView t_kk;
    TextView t_ev;
    TextView t_atolye;


    int tas=0;
    int isci=0;
    int odun=0;
    int gun=0;

    //region Göstergelerin Yazdırıldığı Fonksiyon
    public void g_yaz(TextView g,int sayi){
        g.setText(String.valueOf(sayi));
    }
//endregion


    //region Düğme ve textviewlerin görünürlüğü
    public static void refresh(ImageButton[] b,TextView[] t)
    {
        int[][] yapi=yapilar.yapi;
        for (int i=0;i<yapi.length;i++)
        {
            if(yapi[i][3]==1)
            {
                b[i].setVisibility(View.INVISIBLE);
                t[i].setVisibility(View.INVISIBLE);
            }
            else
            {
                b[i].setVisibility(View.VISIBLE);
                t[i].setVisibility(View.VISIBLE);
            }
        }
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

        kulube=findViewById(R.id.kucukkulube);
        depo=findViewById(R.id.depo);
        ev=findViewById(R.id.ev);
        atolye=findViewById(R.id.atolye);
        b_geri=findViewById(R.id.b_geri);
        t_depo=findViewById(R.id.t_depo);
        t_kk=findViewById(R.id.t_kk);
        t_ev=findViewById(R.id.t_ev);
        t_atolye=findViewById(R.id.t_atolye);


        g_odun=findViewById(R.id.g_odun);
        g_isci=findViewById(R.id.g_isci);
        g_tas=findViewById(R.id.g_tas);
        g_gun=findViewById(R.id.g_gun);

        b_gosterge=new ImageButton[]{kulube,depo,ev,atolye};
        t_gosterge=new TextView[]{t_kk,t_depo,t_ev,t_atolye};


        t_depo.setText("\nDepo\n"+String.valueOf(yapilar.yapi[1][0])+" Odun"+" "+String.valueOf(yapilar.yapi[1][1])+" Taş");

        refresh(b_gosterge,t_gosterge);

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
               {
                   yapilar.yapi[1][3]=0;
                   yapilar.yapi[2][3]=0;
                   refresh(b_gosterge,t_gosterge);
               }
            }
        });
        //endregion

        //region ev butonu
        ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yap(2))
                    yapilar.yapi[3][3]=0;
                refresh(b_gosterge,t_gosterge);
            }
        });
        //endregion

        //region atolye butonu

        atolye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           if(yap(3))
           {
               unlocks.atolye=0;
               refresh(b_gosterge,t_gosterge);
           }
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
                if (yapilar.yapi[1][3]!=1)
                    if(yapilar.yapi[1][0]<=odun && yapilar.yapi[1][1]<=tas)
                    {
                        odun -=yapilar.yapi[1][0];
                        tas -=yapilar.yapi[1][1];

                        yapilar.yapi[1][4]++;

                        g_yaz(g_odun,odun);
                        g_yaz(g_tas,tas);

                        kaynaklar.mtas+=60;
                        kaynaklar.modun+=100+(20*yapilar.yapi[1][4]);

                        yapilar.yapi[1][0]*=1.5*yapilar.yapi[1][4]/2;
                        yapilar.yapi[1][1]+=50;

                        t_depo.setText("\nDepo\n"+String.valueOf(yapilar.yapi[1][0])+" Odun"+" "+String.valueOf(yapilar.yapi[1][1])+" Taş");
                        refresh(b_gosterge,t_gosterge);
                    }
                    else
                        Toast.makeText(uret.this,"Yetersiz Kaynak",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(uret.this,"Bu yapı önceden yapılmış yada şuanda kilitli.",Toast.LENGTH_SHORT).show();
            }
        });

//endregion

    }
}
