package com.example.sqlcurd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseService extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="StudentRecord.db";
    public static final String TABLE_NAME = "STUDENTS";
    public static final String COLUM_ROLLNO = "ROLLNO";
    public static final String COLUM_NAME = "NAME";
    public static final String COLUM_COURSE = "COURSE ";
    public static final String COLUM_AGE = "AGE";

    public DatabaseService( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

String create= "CREATE TABLE " + TABLE_NAME + "( " + COLUM_ROLLNO + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COLUM_NAME +
        " TEXT(50) NOT NULL ," + COLUM_COURSE + "TEXT(30) NOT NULL ," + COLUM_AGE + " INTEGER )";
db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addStudent(Student student) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUM_NAME,student.getName());
        contentValues.put(COLUM_COURSE,student.getCourseName());
        contentValues.put(COLUM_AGE,student.getAge());
        long res = db.insert(TABLE_NAME, null, contentValues);
        if(res==0)
            return true;
        else
            return false;
    }
    public List<Student> getStudents(){
        SQLiteDatabase db=this.getReadableDatabase();
        List<Student> students=new ArrayList<>();
        String statement="SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(statement, null);
        if (cursor.moveToFirst()){
            do {
              Student student= new Student();
              student.setRollNo(Integer.parseInt(cursor.getString(0)));
              student.setName(cursor.getString(1));
              student.setCourseName(cursor.getString(2));
              student.setAge(Integer.parseInt(cursor.getString(3)));
              students.add(student);
            }while (cursor.moveToNext());
        }
        return  students;
    }
    public boolean deleteStudent(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,COLUM_NAME +"=?",new String[]{name});
        return true;
    }
    public void  updateStudent(Student student){
        
    }
}
