package com.example.listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    String[] arr={"tcs","infosys","wipro","hcl","tech mahindra","mindtree","l&t infotech","happiest minds"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list1);
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,arr);
     listView.setAdapter(ad);
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Toast.makeText(MainActivity.this,"you clicked on "+id,Toast.LENGTH_LONG).show();
         }
     });
    }
}