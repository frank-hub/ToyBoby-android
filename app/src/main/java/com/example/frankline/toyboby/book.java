package com.example.frankline.toyboby;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.Calendar;

public class book extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    int day,month,year;
    TextView date;
    Button callBtns;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        final Dialog dialog = new Dialog(this);


//        DatePicker bookCal = (DatePicker)findViewById(R.id.calBook); // get the reference of CalendarView
//        bookCal.setSpinnersShown(true);
//        day = bookCal.getDayOfMonth();
//        month = bookCal.getMonth() + 1;
//        year = bookCal.getYear();
//            Toast.makeText(book.this,day+"/"+month+"/"+year,Toast.LENGTH_SHORT);
        this.date = (TextView) findViewById(R.id.dateTxt);
        this.callBtns = (Button) findViewById(R.id.callBtn);
        callBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                progressDialog=new ProgressDialog(book.this);
                progressDialog.setMessage("Processing Data");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(true);
                progressDialog.setProgress(0);
                progressDialog.show();
                final int totalProgressTime = 50;
                final Thread t = new Thread() {
                    @Override
                    public void run() {
                        int jumpTime = 0;

                        while(jumpTime < totalProgressTime) {
                            try {
                                sleep(200);
                                jumpTime += 5;
                                progressDialog.setProgress(jumpTime);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();
//                ----Make A call----
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0717353774"));
                if (ActivityCompat.checkSelfPermission(book.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });


        CardView openCalendar = (CardView) findViewById(R.id.openDate);
        openCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        Toast.makeText(book.this,currentDateString,Toast.LENGTH_SHORT).show();
        this.date.setText(currentDateString);
    }



}
