package com.example.recycleviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
String[] arr={"Faster Corp","amazone","Apple","Microsoft","Gooogle","facebook","Tencent","Alibaba","Salesforce",
"Doordash","Bitedance"};
RecyclerView recycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview=findViewById(R.id.recyclerView);
        MyAdapter md=new MyAdapter(arr,this);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setAdapter(md);

    }
}