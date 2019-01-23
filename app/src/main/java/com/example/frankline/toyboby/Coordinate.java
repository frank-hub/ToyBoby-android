package com.example.frankline.toyboby;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Coordinates")
public class Coordinate extends Model {
    @Column(name = "latitude")
    public double latitude;
    @Column(name="longitute")
    public double longitude;
}
