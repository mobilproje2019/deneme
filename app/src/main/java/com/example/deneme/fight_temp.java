package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class fight_temp extends AppCompatActivity {

    TextView isim,g_tur,dhp;
    ProgressBar g_hp;
    ListView list;
    Button atak,yetenek,item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_temp);
        isim=findViewById(R.id.txt1);
        g_tur=findViewById(R.id.deneme_tur);
        g_hp=findViewById(R.id.deneme_hp);
        dhp=findViewById(R.id.denemedusmanhp);
        list=findViewById(R.id.denemeliste);
        atak=findViewById(R.id.denemeatak);
        yetenek=findViewById(R.id.denemeskill);
        item=findViewById(R.id.denemeitem);

        yetenek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),yetenek.class);
            }
        });
    }
}
