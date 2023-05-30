package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

interface ClickDelegate {
    void onClick(String text);
    void onClickDelete(String text);
}

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context contex;
    ArrayList<Yemek> list;


    ClickDelegate clickDelegate;


    public MyAdapter(Context contex, ArrayList<Yemek> list, ClickDelegate clickDelegate) {
        this.contex = contex;
        this.list = list;
        this.clickDelegate = clickDelegate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       return new MyViewHolder(LayoutInflater.from(contex).inflate(R.layout.kahvalti_item,parent,false),clickDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Yemek yemek=list.get(position);
        //holder.isim.setText(yemek.getIsim());
        //holder.kalori.setText(yemek.getKalori());

        holder.isim.setText(yemek.getYemek_ad());
        holder.kalori.setText(yemek.getYemek_kalori());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView isim,kalori,adet;



        public MyViewHolder(@NonNull View itemView,ClickDelegate clickDelegate) {
            super(itemView);

            isim=itemView.findViewById(R.id.isim);
            kalori=itemView.findViewById(R.id.kalori);
            adet=itemView.findViewById(R.id.adet);


            itemView.findViewById(R.id.azalt).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String ilkadet=adet.getText().toString();
                    int a =Integer.parseInt(ilkadet);
                    if(a==0){
                        Toast.makeText(itemView.getContext(), "Hiç ürün eklenmedi", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        a=a-1;
                        String sonadet=String.valueOf(a);
                        adet.setText(sonadet);
                        String cal=kalori.getText().toString();
                        clickDelegate.onClickDelete(cal);
                    }

                }
            });

            itemView.findViewById(R.id.arttir_kahvalti).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String ilkadet=adet.getText().toString();

                    int a =Integer.parseInt(ilkadet);
                    a=a+1;
                    String sonadet=String.valueOf(a);
                    adet.setText(sonadet);
                    String cal=kalori.getText().toString();
                    clickDelegate.onClick(cal);

                }
            });





        }
    }


}
