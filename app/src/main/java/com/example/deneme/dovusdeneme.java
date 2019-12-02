package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class dovusdeneme extends AppCompatActivity {

    TextView isim;
    ProgressBar g_hp;
    ListView list;
    Button atak;
    int d_seviye=1;
    int hp=100;
    int dusman=1;
    int tur=0;
    int dhp=100;
    List log;
    ListView listView;

    public void dusmanvurus() {
        for (int i = 0; i < dusman; i++) {
            Random rnd = new Random();

            int hasar = rnd.nextInt(10 + d_seviye * 2) + 1 + d_seviye * 3;

            log.add("Düşman "+hasar+" kadar vurdu.\n");
            hp -=hasar;

            goster();
        }
    }

public void goster()
{
    isim.setText(karakter.isim);
    g_hp.setProgress(hp);
    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,log);

    listView.setAdapter(adapter);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dovusdeneme);

        isim=findViewById(R.id.g_ad);
        g_hp=findViewById(R.id.g_hp);
        atak=findViewById(R.id.b_attack);
        listView= findViewById(R.id.dlog);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,log);

        listView.setAdapter(adapter);

    goster();

        atak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd=new Random();
                dhp -=rnd.nextInt(karakter.stat[0]+20)+1+karakter.stat[0]*3;
                dusmanvurus();
                tur++;
                goster();
            }
        });
    }
}
