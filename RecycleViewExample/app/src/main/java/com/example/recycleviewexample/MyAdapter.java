package com.example.recycleviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
  String[] arr;
  Context context;
public MyAdapter(String[] arr,Context context){
    this.arr=arr;
    this.context=context;
}
    @NonNull
    @Override
    public HoldView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return  new HoldView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.HoldView holder, int position) {
        holder.textView.setText(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class HoldView extends RecyclerView.ViewHolder{
        TextView textView;
        public HoldView(@NonNull View view) {
            super(view);
            textView=view.findViewById(R.id.textView);
        }
    }
}
