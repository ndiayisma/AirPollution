package com.example.airpollution;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private Coord coord;
    private String name;
    private double lat;
    private double lon;


    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }


    public Coord getCoord() {
        return coord;
    }
}
