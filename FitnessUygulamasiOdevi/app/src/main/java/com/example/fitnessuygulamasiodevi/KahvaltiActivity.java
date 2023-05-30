package com.example.fitnessuygulamasiodevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KahvaltiActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapter myAdapter;
    ArrayList<Yemek> list;

    TextView kalorii;

    //
    Button btngonder;
    HashMap<String,Object> mData;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kahvalti);




        kalorii=findViewById(R.id.kalori);
        recyclerView=findViewById(R.id.recView_kahvalti);
        databaseReference=FirebaseDatabase.getInstance().getReference("yemekler");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list=new ArrayList<Yemek>();
        myAdapter=new MyAdapter(this, list, new ClickDelegate() {
            @Override
            public void onClick(String text) {

                String ilkkalori=kalorii.getText().toString();
                int gelenkalori=Integer.parseInt(text);
                int ilkkalorii=Integer.parseInt(ilkkalori);
                int sonhal=gelenkalori+ilkkalorii;

                String sonhals=String.valueOf(sonhal);
                kalorii.setText(sonhals);

            }

            @Override
            public void onClickDelete(String text) {

                String ilkkalori=kalorii.getText().toString();
                int gelenkalori=Integer.parseInt(text);
                int ilkkalorii=Integer.parseInt(ilkkalori);
                int sonhal=ilkkalorii-gelenkalori;

                String sonhals=String.valueOf(sonhal);
                kalorii.setText(sonhals);

            }
        });
        recyclerView.setAdapter(myAdapter);




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Yemek yemek=dataSnapshot.getValue(Yemek.class);
                    list.add(yemek);

                }

                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        /*FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("yemekler");

        Yemekler yemek1=new Yemekler("","Haşlanmış Yumurta(1 adet)","78 cal");
        Yemekler yemek2=new Yemekler("","Omlet (1 Yumurta)","95 cal");
        Yemekler yemek3=new Yemekler("","Sucuklu Yumurta","242 cal");
        Yemekler yemek4=new Yemekler("","Siyah Zeytin(5 adet)","27 cal");
        Yemekler yemek5=new Yemekler("","Peynir(1 porsiyon)","68 cal");
        Yemekler yemek6=new Yemekler("","Domates(1 adet)","19 cal");
        Yemekler yemek7=new Yemekler("","Salatalık(1 adet)","20 cal");
        Yemekler yemek8=new Yemekler("","Salam(1 porsiyon)","150 cal");
        Yemekler yemek9=new Yemekler("","Yeşil Zeytin(5 adet)","35 cal");
        Yemekler yemek10=new Yemekler("","Çilek Reçeli(1 tatlı kaşığı)","11 cal");
        Yemekler yemek11=new Yemekler("","Vişne Reçeli(1 tatlı kaşığı)","14 cal");
        Yemekler yemek12=new Yemekler("","Poğaça","243 cal");
        Yemekler yemek13=new Yemekler("","Börek","400 cal");
        Yemekler yemek14=new Yemekler("","Kahvaltılık Gevrek","120 cal");
        Yemekler yemek15=new Yemekler("","Menemen","177 cal");


        myRef.push().setValue(yemek1);
        myRef.push().setValue(yemek2);
        myRef.push().setValue(yemek3);
        myRef.push().setValue(yemek4);
        myRef.push().setValue(yemek5);
        myRef.push().setValue(yemek6);
        myRef.push().setValue(yemek7);
        myRef.push().setValue(yemek8);
        myRef.push().setValue(yemek9);
        myRef.push().setValue(yemek10);
        myRef.push().setValue(yemek11);
        myRef.push().setValue(yemek12);
        myRef.push().setValue(yemek13);
        myRef.push().setValue(yemek14);
        myRef.push().setValue(yemek15);*/



        databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://fitness-uygulamasi-odevi-default-rtdb.firebaseio.com/");
        btngonder=findViewById(R.id.btngunlukkalori);
        btngonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a="sabah";
                String gkalori= kalorii.getText().toString();
                Intent intent=getIntent();
                String email=intent.getStringExtra("key");
                System.out.println(email);

                databaseReference.child("Kullanici").child(email).child("Bilgi").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        mData=new HashMap<>();
                        mData.put("Kalori",gkalori);
                        mData.put("Vakit",a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });






    }
}