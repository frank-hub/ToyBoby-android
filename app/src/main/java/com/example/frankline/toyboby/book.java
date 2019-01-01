package com.example.frankline.toyboby;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initTabs();
        final Dialog dialog = new Dialog(this);

//        DatePicker bookCal = (DatePicker)findViewById(R.id.calBook); // get the reference of CalendarView
//        bookCal.setSpinnersShown(true);
//        day = bookCal.getDayOfMonth();
//        month = bookCal.getMonth() + 1;
//        year = bookCal.getYear();
//            Toast.makeText(book.this,day+"/"+month+"/"+year,Toast.LENGTH_SHORT);
        this.date = (TextView) findViewById(R.id.dateTxt);


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

    public void initTabs(){
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();


        tabHost.addTab(tabHost.newTabSpec("Morning").setIndicator("Übersicht").setContent(R.id.tab1)); // <- is working fine
        tabHost.addTab(tabHost.newTabSpec("Afternoon").setIndicator("Einstellungen").setContent(new Intent(this, Products.class)));

        tabHost.setOnTabChangedListener();

        tabHost.setCurrentTab(0);
    }
}
