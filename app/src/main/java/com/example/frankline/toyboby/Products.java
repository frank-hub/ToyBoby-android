package com.example.frankline.toyboby;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(Products.this);
        SQLiteDatabase database = sqLiteHelper.getReadableDatabase();

        ArrayList<String> list = new ArrayList<>();
        ListView productLst = (ListView) findViewById(R.id.productList);
        Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS",new String[]{});

        if (cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();

        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);


//
            builder.append("NAME - "+ name + "PRICE -"+ price);
            list.add("NAME - "+ name + "PRICE -"+ price);
        }while (cursor.moveToNext());

        TextView textView = (TextView) findViewById(R.id.products);
        textView.setText(builder.toString());

//        ---------List-------


        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);
        productLst.setAdapter(adapter);

        cursor.close();

//             ----------/List------
        Button appBtn = (Button) findViewById(R.id.btn_app);
        appBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Products.this,book.class);
                startActivity(i);
            }
        });
    }
}
