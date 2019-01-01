package com.example.frankline.toyboby;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Home extends AppCompatActivity {

    public Button insertBtn ,viewBtn;
    public EditText nameInput ,descriptionInput , priceInput;
    Double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameInput = (EditText) findViewById(R.id.name);
        descriptionInput = (EditText) findViewById(R.id.description);
        priceInput = (EditText) findViewById(R.id.price);
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy"); //"HH:mm:ss"
        String currentTime = sdf.format(new Date());

//        priceInput.setText(currentTime);
        insertBtn = (Button) findViewById(R.id.submit);



            insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nameInput.length() == 0 | descriptionInput.length() == 0 | priceInput.length() == 0 ){
                        Toast.makeText(Home.this,"Fill The Fields",Toast.LENGTH_SHORT).show();
                    }else {
                        //        -------Sqlite Database-------
                        String names = nameInput.getText().toString();
                        String desc = descriptionInput.getText().toString();
                        String pricePro = priceInput.getText().toString();
                        price = Double.parseDouble(pricePro);
                        SQLiteHelper sqLiteHelper = new SQLiteHelper(Home.this);
                        SQLiteDatabase database = sqLiteHelper.getReadableDatabase();

                        sqLiteHelper.insertData(names, desc, price, database);


                        Toast.makeText(Home.this, "The Data was Inserted successfully", Toast.LENGTH_SHORT).show();
                        

                    }
                    //        ---------------END-------------
                }
            });



        viewBtn = (Button) findViewById(R.id.view);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Products.class);
                startActivity(intent);
            }
        });

    }

}
