package com.example.fitnessuygulamasiodevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AnaActivity extends AppCompatActivity {

    TextView tvkahvalti,tvogle,tvaksam,tvaraogun;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana);

        tvaksam=findViewById(R.id.tvaksam);
        tvaraogun=findViewById(R.id.tvaraogun);
        tvkahvalti=findViewById(R.id.tvkahvaltı);
        tvogle=findViewById(R.id.tvogle);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







        tvkahvalti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaActivity.this,KahvaltiActivity.class);
                startActivity(i);
            }
        });



        tvogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaActivity.this,OgleActivity.class);
                startActivity(i);
            }
        });

        tvaksam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaActivity.this,AksamActivity.class);
                startActivity(i);
            }
        });

        tvaraogun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaActivity.this,AraOgunActivity.class);
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.anaDon:
                Intent i= new Intent(AnaActivity.this,AnaActivity.class);
                startActivity(i);
                break;

            case R.id.tüketilenkalori:
               // Intent i= new Intent(AnaActivity.this,KalorimActivity.class);
               // startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}