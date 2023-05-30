package com.example.fitnessuygulamasiodevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class KayitActivity extends AppCompatActivity {

    private EditText edIsim,edEmail,edSifre,edSifreOnay;
    private Button btnKayit;
    private FirebaseAuth mAuth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);


        edIsim=findViewById(R.id.kayitIsim);
        edEmail=findViewById(R.id.kayitEmail);
        edSifreOnay=findViewById(R.id.sifreOnay);
        edSifre=findViewById(R.id.Sifre);
        btnKayit=findViewById(R.id.btnKayitOl);
        mAuth=FirebaseAuth.getInstance();


          btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim=edIsim.getText().toString();
                String email=edEmail.getText().toString();
                String sifre=edSifre.getText().toString();
                String sifreOnay=edSifreOnay.getText().toString();


                if(!TextUtils.isEmpty(isim) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(sifre) || !TextUtils.isEmpty(sifreOnay) ){
                    if (sifre.length()<8)
                    {
                        Toast.makeText(KayitActivity.this, "Şifre en az 8 karakterden oluşmalıdır.", Toast.LENGTH_SHORT).show();
                    }
                    if (sifre.equals(sifreOnay)){
                        mAuth.createUserWithEmailAndPassword(email,sifre)
                                .addOnCompleteListener(KayitActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Toast.makeText(getApplicationContext(), "Kayıt olundu!", Toast.LENGTH_SHORT).show();

                                    }
                                });

                    }
                    else {
                        Toast.makeText(KayitActivity.this, "Şifre ve şifre onay aynı olmalı!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(KayitActivity.this, "İstenen verilerden herhangi biri boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });

          








    }
}