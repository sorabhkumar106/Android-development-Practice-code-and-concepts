package com.example.dbcurddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dbcurddemo.adapter.MyAdapter;
import com.example.dbcurddemo.databasehandler.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);
        ArrayList<CompanyInfo> arrayList=new ArrayList<>();
        DatabaseHandler databaseHandler=new DatabaseHandler(this);
//        CompanyInfo fasterCorp=new CompanyInfo();
//        fasterCorp.setCompanyName("faster corp");
//        fasterCorp.setCompanyIndustry("Congmerate");
//        fasterCorp.setCompanyCeo("sorabh kumar");
//        databaseHandler.addCompany(fasterCorp);
//
//        CompanyInfo fasterFinace=new CompanyInfo();
//        fasterFinace.setSerialNo(1);
//        fasterFinace.setCompanyName("Tata Digital Bigbasket");
//        fasterFinace.setCompanyIndustry("Grocery deliviry");
//        fasterFinace.setCompanyCeo("xvz");
//        databaseHandler.updateCompanyInfo(fasterFinace);
//       databaseHandler.addCompany(fasterFinace);

        List<CompanyInfo> list=databaseHandler.showData();
        for(CompanyInfo companyInfo:list){

arrayList.add(companyInfo);
        }
        MyAdapter myAdapter=new MyAdapter(list,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}