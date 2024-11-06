package com.example.airpollution;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class City implements Serializable {
    public City(String name, double lat, double lon, String description) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.cities = new ArrayList<>();
    }

    private ArrayList<City> cities = new ArrayList<>();
    private String name;
    private double lat;
    private double lon;
    private String description;

    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public City(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Ville :  " + this.name + "\nLatitude : " + this.lat + "\nLongitude : " + this.lon;
    }
}
