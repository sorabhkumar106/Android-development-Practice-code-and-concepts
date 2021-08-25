package com.example.dbcurddemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbcurddemo.CompanyInfo;
import com.example.dbcurddemo.MainActivity;
import com.example.dbcurddemo.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<CompanyInfo> list;
    Context context;

    public MyAdapter(List<CompanyInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyAdapter.ViewHolder holder, int position) {
        CompanyInfo companyInfo=list.get(position);
holder.textView.setText(String.valueOf(companyInfo.getSerialNo()));
holder.textView2.setText(companyInfo.getCompanyName());
holder.textView3.setText(companyInfo.getCompanyIndustry());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        TextView textView2;
        TextView textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
        }

        @Override
        public void onClick(View v) {
            int position=this.getAdapterPosition();
            CompanyInfo companyInfo=list.get(position);
            int id=companyInfo.getSerialNo();
            String comp=companyInfo.getCompanyName();
            String indus=companyInfo.getCompanyIndustry();
            String ceo=companyInfo.getCompanyCeo();
            Toast.makeText(this.itemView.getContext(), "id : "+id+"\n "+"Company :"+comp+"\n "+"industry : "+indus,Toast.LENGTH_SHORT).show();

        }
    }
}
