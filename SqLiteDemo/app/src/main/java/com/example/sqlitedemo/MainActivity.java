package com.example.sqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button delete,update,view,insert;
TextView userName,editName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delete=findViewById(R.id.delete);
        insert=findViewById(R.id.insert);
        view=findViewById(R.id.view);
        update=findViewById(R.id.update);

        userName=findViewById(R.id.userName);
        editName=findViewById(R.id.editName);
        password=findViewById(R.id.password);
        Database database=new Database(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editName.getText().toString();
                String username=userName.getText().toString();
                String pass=password.getText().toString();
                if(name.equals("") || username.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"Please fill all the field",Toast.LENGTH_LONG).show();
//                    this.onClick(v);
                }else{
                   boolean b= database.insertData(name,username,pass);
                    if (b)
                        Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Something error happend",Toast.LENGTH_LONG).show();

                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor data=database.dataInfo();
                if (data.getCount()==0){
                    Toast.makeText(MainActivity.this,"data not found",Toast.LENGTH_LONG);
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (data.moveToNext()){
                    stringBuffer.append("name : "+data.getString(0)+"\n");
                    stringBuffer.append("username : "+data.getString(1)+"\n");
                    stringBuffer.append("password : "+data.getString(2)+"\n\n\n");

                }
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Users data");
                builder.setMessage(stringBuffer.toString());
                builder.show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=userName.getText().toString();
               boolean isDelete= database.deleteData(username);
               if(isDelete)
                   Toast.makeText(MainActivity.this,username+"data has been deleted",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(MainActivity.this,username+"data has not  been deleted",Toast.LENGTH_LONG).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editName.getText().toString();
                String username=userName.getText().toString();
                String pass=password.getText().toString();
              boolean isUpdated=  database.updateData(username,name,pass);
              if(isUpdated)
                  Toast.makeText(MainActivity.this,"data is updated",Toast.LENGTH_LONG).show();
              else
                  Toast.makeText(MainActivity.this,"data is not updated",Toast.LENGTH_LONG).show();
            }
        });
    }
}