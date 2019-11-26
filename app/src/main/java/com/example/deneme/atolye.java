package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class atolye extends AppCompatActivity {

    ImageButton b_balta,b_dtas,b_cubuk,b_tahta,b_kazma,b_kilic;
    TextView g_odun,g_tas,g_dtas,g_tahta,g_cubuk;

    int odun=0,tas=0,dtas=0,tahta=0,cubuk=0;
    int[] kaynak;

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
           if(kaynak[j]>=araclar.araclar[i][j])
           {  Toast.makeText(atolye.this,"Araç Başarıyla Yapıldı",Toast.LENGTH_SHORT).show();}
           else
           {
               Toast.makeText(atolye.this,String.valueOf(kaynak[j]),Toast.LENGTH_SHORT).show();
               Toast.makeText(atolye.this,"Yetersiz Kaynak",Toast.LENGTH_SHORT).show();
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

        kaynak= new int[]{odun, tas, tahta, dtas, cubuk};

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

                g_all();
            }
            }
        });
//endregion






    }
}
