package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class info extends AppCompatActivity {
    ToggleButton b_siniflar;
    TextView g_siniflar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        g_siniflar=findViewById(R.id.g_siniflar);
        b_siniflar=findViewById(R.id.b_siniflar);

        b_siniflar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    g_siniflar.setText(getResources().getString(R.string.g_siniflar));
                }
                else
                {
                    g_siniflar.setText("");
                }
            }
        });

    }
}
