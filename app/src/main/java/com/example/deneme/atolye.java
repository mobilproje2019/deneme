package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import java.util.TimerTask;
import java.util.Timer;


public class atolye extends AppCompatActivity {


    Handler handler = new Handler();
    Timer timer=new Timer();

    ImageButton b_balta,b_dtas,b_cubuk,b_tahta,b_kazma,b_kilic;
    TextView g_odun,g_tas,g_dtas,g_tahta,g_cubuk;
    TextView tx[];
    int odun=0,tas=0,dtas=0,tahta=0,cubuk=0;
    int[] kaynak;


    //region Renkler
    public void k(int j)
    {
        tx[j].setTextColor(Color.parseColor("#aa0114"));
    }
    public void s(int j)
    {
        tx[j].setTextColor(Color.parseColor("#000000"));
    }
//endregion

    //region Timer Task BURSI 3 SANİYE SONRA KIRMIZI YAZIYI SİYAH YAPMAK İÇİN KULLLANILCAK
    TimerTask tik= new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    };
    //endregion

    //region Yazdırma
    public void g_yaz(TextView g,int sayi)
    {
        g.setText(String.valueOf(sayi));
    }

    public void g_all()
    {
        g_odun.setText(String.valueOf(odun));
        g_tas.setText(String.valueOf(tas));
        g_dtas.setText(String.valueOf(dtas));
        g_tahta.setText(String.valueOf(tahta));
        g_cubuk.setText(String.valueOf(cubuk));
    }
    //endregion

    //region Üretme Fonksiyonu
    public boolean uret(int i)
    {
        if(araclar.araclar[i][5]==0)
        {
          for(int j=0;j<araclar.araclar.length-1;j++)
          {
           if(kaynak[j]<araclar.araclar[i][j])
           {
               Log.v("tag",String.valueOf(kaynak[j])+"  "+String.valueOf(araclar.araclar[i][j]));
               k(j);
               tx[j].setTextSize(18);
               return false;
           }
          }
        }
        else {
            Toast.makeText(atolye.this, "Şuanda bu aracı yapamazsın", Toast.LENGTH_SHORT).show();
            return false;
        }
     return true;
    }
    //endregion


    //region Kaynak dizi yenilemesi
    public void yenile()
    {
        kaynak=new int[]{odun, tas, tahta, dtas, cubuk};
    }
    //endregion




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atolye);

        b_balta=findViewById(R.id.b_balta);
        b_dtas=findViewById(R.id.b_dtas);
        b_cubuk=findViewById(R.id.b_cubuk);
        b_tahta=findViewById(R.id.b_tahta);
        b_kazma=findViewById(R.id.b_kazma);
        b_kilic=findViewById(R.id.b_kilic);

        g_odun=findViewById(R.id.g_odun);
        g_tas=findViewById(R.id.g_tas);
        g_dtas=findViewById(R.id.g_dtas);
        g_tahta=findViewById(R.id.g_tahta);
        g_cubuk=findViewById(R.id.g_cubuk);

        odun=kaynaklar.odun;
        tas=kaynaklar.tas;
        dtas=kaynaklar.dtas;
        tahta=kaynaklar.tahta;
        cubuk=kaynaklar.cubuk;

        yenile();
        tx=new TextView[]{ g_odun,g_tas,g_tahta,g_dtas,g_cubuk};
        // Yazdırma
        g_all();

        //region Tahta Butonu
        b_tahta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(uret(0))
            {
                kaynaklar.tahta+=5;
                kaynaklar.odun-=1;

                odun=kaynaklar.odun;
                tahta=kaynaklar.tahta;
                yenile();
                g_all();
            }
            }
        });
//endregion

        //region DTaş Butonu
        b_dtas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uret(1))
                {
                    kaynaklar.dtas+=5;
                    kaynaklar.tas-=25;

                    tas=kaynaklar.tas;
                    dtas=kaynaklar.dtas;
                    yenile();
                    g_all();
                }
            }
        });
        //endregion

        //region Çubuk Butonu
        b_cubuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uret(2))
                {
                    kaynaklar.cubuk+=5;
                    kaynaklar.tahta-=2;

                    cubuk=kaynaklar.cubuk;
                    tahta=kaynaklar.tahta;
                    yenile();
                    g_all();
                }
            }
        });
        //endregion

        //region Balta
        b_balta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uret(3))
                {
                    kaynaklar.dtas-=5;
                    kaynaklar.cubuk-=2;

                    cubuk=kaynaklar.cubuk;
                    dtas=kaynaklar.dtas;
                    yenile();
                    araclar.araclar[3][5]=1;
                    Toast.makeText(atolye.this,"Artık Ağaç Keserek Daha Fazla Odun Elde Edebilirsiniz",Toast.LENGTH_SHORT).show();
                    g_all();
                }
            }
        });
        //endregion

        //region Kazma
        b_kazma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uret(4))
                {
                    kaynaklar.dtas-=8;
                    kaynaklar.cubuk-=2;

                    cubuk=kaynaklar.cubuk;
                    dtas=kaynaklar.dtas;
                    araclar.araclar[4][5]=1;
                    Toast.makeText(atolye.this,"Artık Madende Taş Kazabilirsiniz",Toast.LENGTH_SHORT).show();
                    yenile();
                    g_all();
                }
            }
        });
        //endregion



    }
}
