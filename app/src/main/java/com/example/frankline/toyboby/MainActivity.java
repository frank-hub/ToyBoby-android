package com.example.frankline.toyboby;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     Button callBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ********Active_Android*******
        LocationModel newLocationModel = new LocationModel();
        newLocationModel.locationName = "Kericho";
        newLocationModel.locationDescription = "Home area";

        newLocationModel.locationCoordinate = new Coordinate();
        newLocationModel.locationCoordinate.latitude = 43.62;
        newLocationModel.locationCoordinate.longitude = 116.200;

        newLocationModel.save();
        newLocationModel.locationCoordinate.save();
//
//        List<LocationModel>storedLoationModels = LocationModel.getAllLocations();
//        Log.d("EA","All Done");

//        END
        callBtn =(Button) findViewById(R.id.contact);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0717353774"));
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
