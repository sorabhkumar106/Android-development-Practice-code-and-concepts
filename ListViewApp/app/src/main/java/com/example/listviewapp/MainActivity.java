package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> al;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"tutyio",Toast.LENGTH_LONG);
            }
        });
        al=new ArrayList<>();
        al.add("faster ai & analytics");
        al.add("faster Finacial services");
        al.add("faster Digital Services");
        al.add("faster Saas products");
        al.add("faster Holding");
        al.add("faster ai & analytics");
        al.add("faster Finacial services");
        al.add("faster Digital Services");
        al.add("faster Saas products");
        al.add("faster Holding");
        al.add("faster ai & analytics");
        al.add("faster Finacial services");
        al.add("faster Digital Services");
        al.add("faster Saas products");
        al.add("faster Holding");
        ArrayAdapter<String> ad=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,al);
        list.setAdapter(ad);
    }
}