package com.example.frankline.toyboby;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Locations")
public class LocationModel extends Model {
    @Column(name = "location_name")
    public String locationName;
    @Column(name = "location_description")
    public String locationDescription;

    @Column(name = "location_coordinate")
    public Coordinate locationCoordinate;

//    public static List<LocationModel>getAllLocations(){
//        return new Select().from(LocationModel.class).execute();
//    }
LocationModel()
{
    super();
}

}
