package com.example.airpollution;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherServices {
    @GET("air_pollution?lat=51.5085&lon=-0.2812&appid=e075a0b59517e88cc46940bb262add13")
    Call<AirQuality> getLondon();
    @GET("air_pollution?lat=48.8583&lon=2.3488&appid=e075a0b59517e88cc46940bb262add13")
    Call<AirQuality> getParis();

    @GET("air_pollution?lat=51.5085&lon=-0.2812&appid=e075a0b59517e88cc46940bb262add13")
    Call<City> getLondonCoord();

    @GET("air_pollution")
    Call<AirQuality> getAirQuality(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String apiKey);
}