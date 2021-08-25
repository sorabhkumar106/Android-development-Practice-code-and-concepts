package com.example.dbcurddemo.databasehandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.dbcurddemo.CompanyInfo;
import com.example.dbcurddemo.params.Params;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = " CREATE TABLE " + Params.TABLE_NAME + " ( " + Params.KEY_SNO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Params.KEY_NAME + " TEXT NOT NULL ," + Params.KEY_INDUSTRY + " TEXT NOT NULL , " +
                Params.KEY_CEO + " TEXT" + ") ";
        db.execSQL(q);
        Log.d("sorabh","query"+q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
  public boolean addCompany(CompanyInfo companyInfo){
        SQLiteDatabase database=this.getWritableDatabase();
      ContentValues contentValues=new ContentValues();
      boolean flag=false;
      contentValues.put(Params.KEY_NAME,companyInfo.getCompanyName());
      contentValues.put(Params.KEY_INDUSTRY,companyInfo.getCompanyIndustry());
      contentValues.put(Params.KEY_CEO,companyInfo.getCompanyCeo());
      database.insert(Params.TABLE_NAME,null,contentValues);
      Log.d("sorabh","added  company successfully");
      flag=true;
      database.close();
  return  flag;
  }
  public List<CompanyInfo> showData() {
      String query = "SELECT * FROM " + Params.TABLE_NAME;
      SQLiteDatabase db = this.getReadableDatabase();
      List<CompanyInfo> list = new ArrayList<>();
      Cursor cursor = db.rawQuery(query, null);
      Log.d("sorabh","show_____________________________");
      if (cursor.moveToFirst()) {
          do {
              CompanyInfo companyInfo = new CompanyInfo();
              companyInfo.setSerialNo(Integer.parseInt(cursor.getString(0)));
              companyInfo.setCompanyName(cursor.getString(1));
              companyInfo.setCompanyIndustry(cursor.getString(2));
              companyInfo.setCompanyCeo(cursor.getString(3));
              list.add(companyInfo);
          } while (cursor.moveToNext());

      }
      return list;
  }
  public  int updateCompanyInfo(CompanyInfo companyInfo){
        SQLiteDatabase db=this.getWritableDatabase();
ContentValues values=new ContentValues();
values.put(Params.KEY_NAME,companyInfo.getCompanyName());
values.put(Params.KEY_INDUSTRY,companyInfo.getCompanyIndustry());
values.put(Params.KEY_CEO,companyInfo.getCompanyCeo());
        return db.update(Params.TABLE_NAME,values,Params.KEY_SNO+ "=?",new String[]{String.valueOf(companyInfo.getSerialNo())});

  }
  public void deleteCompany(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_SNO +"=?",new String[]{String.valueOf(id)});
  }
  public int getlenth(){
        String q="SELECT * FROM "+Params.TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(q,null);
        return  cursor.getCount();
  }
}
