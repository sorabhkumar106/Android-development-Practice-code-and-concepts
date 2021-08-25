package com.example.sqlcurd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,courseName , age;

Button show, add, delete, update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        courseName = findViewById(R.id.courseName);
        age = findViewById(R.id.age);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        show = findViewById(R.id.show);
        update = findViewById(R.id.update);
        DatabaseService databaseService = new DatabaseService(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = name.getText().toString();
                String course = courseName.getText().toString();
                int studentAge= Integer.parseInt(age.getText().toString());
                Student student = new Student(studentName, course,studentAge);
                Log.d("sorabh", "---------------------------------------");


             boolean feedback= databaseService.addStudent(student);
             if(feedback)
                 Toast.makeText(MainActivity.this,student.toString()+" added successfully",Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(MainActivity.this,student.toString()+" not added successfully",Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     boolean res=databaseService.deleteStudent(name.getText().toString());
     if (res)
         Toast.makeText(getBaseContext(),"Student deleted successfully ",Toast.LENGTH_SHORT).show();
     else
         Toast.makeText(getBaseContext(),"Student not deleted successfully ",Toast.LENGTH_SHORT).show();
    }
});
    }
}