package com.example.deneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    Button newgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newgame = findViewById(R.id.button);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anamenu= new Intent(MainActivity.this,olusturma.class);
                startActivity(anamenu);
            }
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("ClickerRPG");
        builder.setIcon(R.mipmap.saydamlogo);
        builder.setCancelable(false);
        builder.setMessage("Uygulamadan çıkmak istediğinize emin misiniz?");
        builder.setNegativeButton("Hayır", null);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                moveTaskToBack(true);
            }
        });
        builder.show();
    }

}
