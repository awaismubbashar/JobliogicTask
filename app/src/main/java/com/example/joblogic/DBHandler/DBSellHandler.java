package com.example.joblogic.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.joblogic.Model.SellModel;
import com.example.joblogic.Utills.SellUtill;

import java.util.ArrayList;
import java.util.List;

public class DBSellHandler extends SQLiteOpenHelper {


    public DBSellHandler(@Nullable Context context) {
        super(context, SellUtill.DATABASE_NAME,null,SellUtill.DATABASE_VERSION);
    }

    // creating table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SELL_TABLE_QUERY = "CREATE TABLE " + SellUtill.TABLE_NAME + "("
                    + SellUtill.SELL_ID + " INTEGER PRIMARY KEY,"
                    + SellUtill.SELL_NAME + " TEXT,"
                    + SellUtill.SELL_PRICE + " TEXT,"
                    + SellUtill.SELL_QUANTITY + " TEXT,"
                    + SellUtill.SELL_TYPE + " TEXT" + ")";

        db.execSQL(CREATE_SELL_TABLE_QUERY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // Add Sell Info
    public void addSellInfo(SellModel sellmodel){
        SQLiteDatabase db  =this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(SellUtill.SELL_NAME, sellmodel.getName());
        value.put(SellUtill.SELL_PRICE, sellmodel.getPrice());
        value.put(SellUtill.SELL_QUANTITY, sellmodel.getQuantity());
        value.put(SellUtill.SELL_TYPE, sellmodel.getType());

        db.insert(SellUtill.TABLE_NAME,null,value);
        db.close();
    }

    // Get all Sell Data
    public List<SellModel> getAllSellData(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<SellModel> sellmodelList = new ArrayList<>();

        String selectAll = "SELECT * FROM "+SellUtill.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        if (cursor.moveToFirst()){
            do {
                SellModel sellModel  =new SellModel();

                sellModel.setId(cursor.getString(0));
                sellModel.setName(cursor.getString(1));
                sellModel.setPrice(cursor.getString(2));
                sellModel.setQuantity(cursor.getString(3));
                sellModel.setType(cursor.getString(4));

                // add data to list
                sellmodelList.add(sellModel);
            }while (cursor.moveToNext());
        }
        return sellmodelList;
    }

    //Get contacts count
    public int getContactCount(){
        String countQuery = "SELECT * FROM "+ SellUtill.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db. rawQuery(countQuery,null);

        // we can't return database after closing database
        //        db.close();

        return cursor.getCount();
    }
}
