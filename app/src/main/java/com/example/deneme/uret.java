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

    ImageButton kulube;
    TextView g_odun;
    TextView g_isci;
    TextView g_tas;
    TextView g_gun;
    Button b_geri;

    kaynaklar nesne=new kaynaklar();

    int tas=0;
    int isci=0;
    int odun=0;
    int gun=0;
    int[] kaynak=new int[4];
    int[][] yapilar={
            {35,0,0,0,0},         // odun ,tas ,isci ,kilitlimi? ,daha önce yapıldımı
            {60,0,0,0,0},
            {75,60,0,0,0},
            {35,60,0,0,0},
                     };

    //region Göstergelerin Yazdırıldığı Fonksiyon
    public void g_yaz(TextView g,int sayi){
        g.setText(String.valueOf(sayi));
    }
//endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uret);

        kulube= findViewById(R.id.kucukkulube);
        b_geri=findViewById(R.id.b_geri);

        g_odun=findViewById(R.id.g_odun);
        g_isci=findViewById(R.id.g_isci);
        g_tas=findViewById(R.id.g_tas);
        g_gun=findViewById(R.id.g_gun);

        //region Verilerin Diziyle Alınıp Aktarılması


        kaynak=getIntent().getIntArrayExtra("veri");
        odun=kaynak[0];
        tas=kaynak[1];
        isci=kaynak[2];
        gun=kaynak[3];
        g_yaz(g_odun,odun);
        g_yaz(g_tas,tas);
        g_yaz(g_isci,isci);
        g_yaz(g_gun,gun);
        //endregion f

        //region kulube butonu
        kulube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yapilar[0][3]!=1 && yapilar[0][4]==0)
                    if(yapilar[0][0]<odun && yapilar[0][1]<tas)
                    {
                        odun -=yapilar[0][0];
                        tas -=yapilar[0][1];
                        yapilar[0][4]++;
                        g_yaz(g_odun,odun);
                        g_yaz(g_tas,tas);
                    }
                else
                   Toast.makeText(uret.this,"Yetersiz Kaynak",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(uret.this,"Bu yapı önceden yapılmış yada şuanda kilitli.",Toast.LENGTH_SHORT).show();

            }
        });
//endregion


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

    }
}
