package com.example.userintercationdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
     private String petNameRva[];
     private String petDescRva[];
     private int imgResourceRva[];
     private Context ctx;

    public RecyclerViewAdapter(Context c1,String petName[],String petDesc[],int imgResource[]){
       ctx=c1;
       petNameRva=petName;
       petDescRva=petDesc;
       imgResourceRva=imgResource;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater recyclerInflater=LayoutInflater.from(ctx);
        View recyclerView=recyclerInflater.inflate(R.layout.recyclerviewlayout,null);
        return new RecyclerViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.t1.setText(petNameRva[position]);
        holder.t2.setText(petDescRva[position]);
        holder.i1.setImageResource(imgResourceRva[position]);

    }

    @Override
    public int getItemCount() {
        return petNameRva.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView i1;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.tvName);
            t2=(TextView)itemView.findViewById(R.id.tvDesc);
            i1=(ImageView)itemView.findViewById(R.id.imvRecyclerViewLayout);
        }
    }
}
