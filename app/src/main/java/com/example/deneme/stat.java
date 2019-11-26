package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import  android.widget.TextView;
import  android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import org.w3c.dom.Text;

public class stat extends AppCompatActivity {

    TextView isim,g_str,g_agi,g_int,g_point;

    Button ileri,mstr,pstr,magi,pagi,mint,pint,i;

    int point=karakter.point,str=karakter.stat[0],agi=karakter.stat[1],inte=karakter.stat[2];

    public static String k[] = {"Güç:","Çvk:","Zeka:"};

    public static void yaz(TextView textView,int i)
    {
        textView.setText(k[i]+karakter.stat[i]);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
//region id tanımlama
        isim=findViewById(R.id.isim);
        g_str=findViewById(R.id.g_str);
        g_agi=findViewById(R.id.g_agi);
        g_int=findViewById(R.id.g_int);
        g_point=findViewById(R.id.g_point);

        ileri=findViewById(R.id.ileri);
        i= findViewById(R.id.info);
        mstr=findViewById(R.id.mstr);
        pstr=findViewById(R.id.pstr);
        magi=findViewById(R.id.magi);
        pagi=findViewById(R.id.pagi);
        mint=findViewById(R.id.mint);
        pint=findViewById(R.id.pint);
//endregion

        isim.setText(karakter.isim);
        g_str.setText("Güç:"+karakter.stat[0]);
        g_agi.setText("Çvk:"+karakter.stat[1]);
        g_int.setText("Zeka:"+karakter.stat[2]);
        g_point.setText(String.valueOf(karakter.point));

//region Plus Tuşları
        pstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(point>0)
            {
                karakter.stat[0]++;
                point--;
                yaz(g_str,0);
                g_point.setText(String.valueOf(point));
            }
            }
        });
        pagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(point>0)
                {
                    karakter.stat[1]++;
                    point--;
                    yaz(g_agi,1);
                    g_point.setText(String.valueOf(point));
                }
            }
        });
        pint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(point>0)
                {
                    karakter.stat[2]++;
                    point--;
                    yaz(g_int,2);
                    g_point.setText(String.valueOf(point));
                }
            }
        });
//endregion

// region Minus Tuşları
        mstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(karakter.stat[0]>str)
                {
                    karakter.stat[0]--;
                    point++;
                    yaz(g_str,0);
                    g_point.setText(String.valueOf(point));
                }
            }
        });
        magi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(karakter.stat[1]>agi)
                {
                    karakter.stat[1]--;
                    point++;
                    yaz(g_agi,1);
                    g_point.setText(String.valueOf(point));
                }
            }
        });
        mint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(karakter.stat[2]>inte)
                {
                    karakter.stat[2]--;
                    point++;
                    yaz(g_int,2);
                    g_point.setText(String.valueOf(point));
                }
            }
        });
//endregion


//region ilerle tuşu
        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(point>0)
                    Toast.makeText(stat.this,"Lütfen Tüm Yetenek Puanlarını Harcayınız",Toast.LENGTH_SHORT).show();
                else {
                    str=karakter.stat[0];
                    agi=karakter.stat[1];
                    inte=karakter.stat[2];
                    karakter.point=point;
                    Intent anaekran = new Intent(stat.this, anaekran.class);
                    startActivity(anaekran);
                }
            }
        });
//endregion

//region i butonu (info)
i.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    Intent info=new Intent(stat.this,info.class);
    startActivity(info);
    }
});
//endregion



    }
}
