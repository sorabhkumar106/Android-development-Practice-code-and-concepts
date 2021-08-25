package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
   private static final String dbName="MyDatabase.db";
    public Database(@Nullable Context context) {
        super(context,dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String q="create table users(id Integer primary key autoincrement ,name text,username text,password text)";
db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
onCreate(db);
    }
    public boolean insertData(String name,String username,String password){
     SQLiteDatabase database=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("username",username);
        c.put("password",password);
        long r=database.insert("users",null,c);
        if(r==-1)return false;
        else
            return true;
    }
    public Cursor dataInfo(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("select * from users",null);
        return cursor;

    }
    public boolean deleteData(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0){
            int r=db.delete("users","username",new String[]{username});
            if (r==-1)return false;
            else  return true;
        }
        else
            return false;
    }
    public boolean updateData(String username,String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("password",password);
        Cursor cursor =db.rawQuery("select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0){
            int res=db.update("users",c,"username=?",new String[]{username});
            if(res==-1)return false;
            else return true;
        }
        return false;
    }
}
