package com.example.sqlcurd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewD extends RecyclerView.Adapter<RecycleViewD.ViewHolde> {
    List<Student> list;
    Context context;

    public RecycleViewD(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
        Log.d("sorabh","oncreate holder");
    }

    @Override
    public ViewHolde onCreateViewHolder(  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_file,parent,false);
        Log.d("sorabh","oncreate holder");
        return new ViewHolde(view);
    }

    @Override
    public void onBindViewHolder(  RecycleViewD.ViewHolde holder, int position) {
Student student=list.get(position);
holder.rollNo.setText(String.valueOf(student.getRollNo()));
holder.name.setText(student.getName());
holder.course.setText(student.getCourseName());
holder.age.setText(String.valueOf(student.getAge()));
        Log.d("sorabh","on bind holder");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        TextView rollNo,name,course,age;

        public ViewHolde(View itemView) {
            super(itemView);
            rollNo=itemView.findViewById(R.id.textView2);
            name=itemView.findViewById(R.id.textView3);
            course=itemView.findViewById(R.id.textView4);
            age=itemView.findViewById(R.id.textView5);
        }
    }
}
