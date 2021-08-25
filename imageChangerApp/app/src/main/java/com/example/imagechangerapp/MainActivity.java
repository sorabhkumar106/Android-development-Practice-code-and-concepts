package com.example.imagechangerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ImageView imageView;
    ArrayList<Integer> arrayList;
    Button next;
    Button prev;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView2);
        next=findViewById(R.id.next);
        prev=findViewById(R.id.prev);
        arrayList=new ArrayList<>();
        arrayList.add(R.drawable.img1);
        arrayList.add(R.drawable.img2);
        arrayList.add(R.drawable.img3);
        arrayList.add(R.drawable.img4);
        arrayList.add(R.drawable.img5);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==4)
                i=0;
                else
                    i++;
                imageView.setImageResource(arrayList.get(i));
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                    i=4;
                else
                    i--;
                imageView.setImageResource(arrayList.get(i));
            }
        });
    }
}