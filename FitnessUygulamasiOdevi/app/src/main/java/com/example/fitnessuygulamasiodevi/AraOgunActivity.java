package com.example.fitnessuygulamasiodevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class AraOgunActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapterAra myAdapterAra;
    ArrayList<AraOgun> list;
    TextView kalorii;

    //
    Button btngonder;
    HashMap<String,Object> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ara_ogun);

        kalorii=findViewById(R.id.kalori);
        recyclerView=findViewById(R.id.recView_araogun);
        databaseReference= FirebaseDatabase.getInstance().getReference("araOgun");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<AraOgun>();
        myAdapterAra=new MyAdapterAra(this, list, new ClickDelegate4() {
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
        recyclerView.setAdapter(myAdapterAra);

       /* AraOgun ara1 = new AraOgun("Kakaolu yulaf lapası","120 cal","");
        AraOgun ara2 = new AraOgun("Cocostar yulaf lapası","250 cal","");
        AraOgun ara3 = new AraOgun("Tiramisu yulaf lapası","270 cal","");
        AraOgun ara4 = new AraOgun("Kakaolu irmik lapası","356 cal","");
        AraOgun ara5 = new AraOgun("Meyveli bowl","320 cal","");
        AraOgun ara6 = new AraOgun("Elma","47 cal","");
        AraOgun ara7 = new AraOgun("Çilek(1 kase)","46 cal","");
        AraOgun ara8 = new AraOgun("Portakal(1 adet)","101 cal","");
        AraOgun ara9 = new AraOgun("Fındık(1 avuç)","151 cal","") ;
        AraOgun ara10 = new AraOgun("Ceviz(1 adet)","31 cal","");
        AraOgun ara11 = new AraOgun("Kavrulmuş badem(25 gr)","140 cal","");
        AraOgun ara12= new AraOgun("Leblebi(1 avuç)","107 cal","");
        AraOgun ara13= new AraOgun("Sütlü çikolata(1 porsiyon)","54 cal","");
        AraOgun ara14= new AraOgun("Bitter çikolata(2 kare)","54 cal","");
        AraOgun ara15 = new AraOgun("Gofret","200 cal","");


        databaseReference.push().setValue(ara1);
        databaseReference.push().setValue(ara2);
        databaseReference.push().setValue(ara3);
        databaseReference.push().setValue(ara4);
        databaseReference.push().setValue(ara5);
        databaseReference.push().setValue(ara6);
        databaseReference.push().setValue(ara7);
        databaseReference.push().setValue(ara8);
        databaseReference.push().setValue(ara9);
        databaseReference.push().setValue(ara10);
        databaseReference.push().setValue(ara11);
        databaseReference.push().setValue(ara12);
        databaseReference.push().setValue(ara13);
        databaseReference.push().setValue(ara14);
        databaseReference.push().setValue(ara15);*/




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    AraOgun araOgun=dataSnapshot.getValue(AraOgun.class);
                    list.add(araOgun);

                }

                myAdapterAra.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}