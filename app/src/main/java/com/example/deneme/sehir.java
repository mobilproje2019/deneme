package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;


public class sehir extends AppCompatActivity {

    Button yerleske;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehir);
    yerleske=findViewById(R.id.yerleske);



    //region Yerleşke
        yerleske.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //endregion

    }
}
