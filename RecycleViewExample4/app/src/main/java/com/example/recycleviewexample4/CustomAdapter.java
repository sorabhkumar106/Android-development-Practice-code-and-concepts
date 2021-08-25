package com.example.recycleviewexample4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    ArrayList<Contacts> arrayList;
    Context context;
    public CustomAdapter(Context context,ArrayList<Contacts> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public CustomAdapter.CustomHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contact_layout,parent,false);

        return  new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CustomAdapter.CustomHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());
        holder.textView2.setText(arrayList.get(position).getSno());
        holder.textView3.setText(arrayList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class CustomHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        public CustomHolder(@NonNull  View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
        }
    }
}
