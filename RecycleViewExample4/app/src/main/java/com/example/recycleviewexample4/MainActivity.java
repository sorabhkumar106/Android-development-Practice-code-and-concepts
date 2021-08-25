package com.example.recycleviewexample4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomAdapter cd;
    ArrayList<Contacts>  arrayList;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList=new ArrayList<Contacts>();
        Contacts c1=new Contacts(1,992788214, "office");
        Contacts c3=new Contacts(2,992788214, "ghar");
        Contacts c2=new  Contacts(3,992788214, "school");
        Contacts c4=new Contacts(2,992788214, "ghar");
        Contacts c5=new Contacts(4,992788214, "office");
        Contacts c6=new Contacts(5,992788214, "school");
        Contacts c7=new Contacts(6,992788214, "ghar");
        Contacts c8=new Contacts(7,992788214, "office");
        Contacts c9=new Contacts(8,992788214, "school");
        arrayList.add(c1);
        arrayList.add(c2);
        arrayList.add(c3);
        arrayList.add(c4);
        arrayList.add(c5);
        arrayList.add(c6);
        arrayList.add(c7);
        arrayList.add(c8);
        arrayList.add(c9);
        recyclerView=findViewById(R.id.recyclerView);
recyclerView.setHasFixedSize(true);
cd=new CustomAdapter(this,arrayList);
LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
linearLayoutManager.setInitialPrefetchItemCount(RecyclerView.VERTICAL);
recyclerView.setLayoutManager(linearLayoutManager);
recyclerView.setAdapter(cd);

    }
}