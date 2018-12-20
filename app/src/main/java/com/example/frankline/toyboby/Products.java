package com.example.frankline.toyboby;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(Products.this);
        SQLiteDatabase database = sqLiteHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS",new String[]{});

        if (cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();

        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);

            builder.append("NAME - "+ name + "PRICE -"+ price);
        }while (cursor.moveToNext());

        TextView textView = (TextView) findViewById(R.id.products);
        textView.setText(builder.toString());
    }
}
