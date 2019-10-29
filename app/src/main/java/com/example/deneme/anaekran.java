package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;

public class anaekran extends AppCompatActivity {
    Button b_odun;
    Button b_odun2;
    TextView g_odun;
    TextView g_isci;

    int isci=0;
    int odun=0;

    Timer tiktak = new Timer();
    Handler handler=new Handler();


    // Timer Çalıştırığı İşlemler
    TimerTask zaman= new TimerTask() {
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);

    g_odun=findViewById(R.id.g_odun);
    b_odun=findViewById(R.id.b_odun);
    b_odun2=findViewById(R.id.b_odun2);
    g_isci=findViewById(R.id.g_isci);

        //Timer Parametreleri ve Başlatıcısı
    tiktak.schedule(zaman,1000,3000);


//Odun Kes Butonu
    b_odun.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            odun++;
            g_yaz(g_odun,odun);
        }
    });


    b_odun2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isci++;
            g_yaz(g_isci,isci);
        }
    });

    }
}
