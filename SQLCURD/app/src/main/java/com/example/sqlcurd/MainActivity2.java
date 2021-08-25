package com.example.sqlcurd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.recycleView);
        ArrayList<Student> arrayList=new ArrayList<>();
        DatabaseService DatabaseService=new DatabaseService(this);



        List<Student> list=DatabaseService.getStudents();
        for(Student Student:list){

            arrayList.add(Student);
        }
        RecycleViewD RecycleViewD=new RecycleViewD(arrayList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(RecycleViewD);

    }
}