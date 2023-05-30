package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


interface ClickDelegate4{
    void onClick(String text);
    void onClickDelete(String text);
}
public class MyAdapterAra extends RecyclerView.Adapter<MyAdapterAra.MyViewHolder> {

    Context context;
    ArrayList<AraOgun> list;

    ClickDelegate4 clickDelegate;

    public MyAdapterAra(Context context, ArrayList<AraOgun> list, ClickDelegate4 clickDelegate) {
        this.context = context;
        this.list = list;
        this.clickDelegate = clickDelegate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.ara_item,parent,false),clickDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AraOgun araogun=list.get(position);
        holder.isim.setText(araogun.getYemek_ad());
        holder.kalori.setText(araogun.getYemek_kalori());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView isim,kalori,adet;

        public MyViewHolder(@NonNull View itemView,ClickDelegate4 clickDelegate) {
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

            itemView.findViewById(R.id.arttir_ara).setOnClickListener(new View.OnClickListener() {
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
