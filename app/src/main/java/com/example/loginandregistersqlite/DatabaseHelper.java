package com.example.loginandregistersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;

    }

    public boolean chkemail(String email){
        SQLiteDatabase db =this.getReadableDatabase() ;
        Cursor cursor=db.rawQuery("select * from user where email =? ", new String[]{email}) ;
        if(cursor.getCount() >0){
            return false ;
        }else
            return true ;

    }
    boolean checkpassword(String password){
        SQLiteDatabase db =this.getReadableDatabase() ;
        Cursor cursor=db.rawQuery("select * from user where password =? ", new String[]{password}) ;
        if(cursor.getCount() >0){
            return false ;
        }else
            return true ;

    }


    boolean checkEmailAndPassword(String email,String  passwrod){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=? and password=?", new String[] {email, passwrod}) ;
        if(cursor.getCount() >0){
            return false ;
        }else return true ;

    }
}


