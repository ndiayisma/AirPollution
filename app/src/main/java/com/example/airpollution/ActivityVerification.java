package com.example.airpollution;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityVerification extends AppCompatActivity {

    private OpenWeatherServices openWeatherServices;
    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);

        double lat = getIntent().getDoubleExtra("latitude", 0);
        double lon = getIntent().getDoubleExtra("longitude", 0);


        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        openWeatherServices = retrofit.create(OpenWeatherServices.class);

        // Fetch AirQuality data

        fetchAirQualityData(lat, lon); // Example coordinates for London
    }

    private void fetchAirQualityData(double lat, double lon) {
        Call<AirQuality> call = openWeatherServices.getAirQuality(lat, lon, "e075a0b59517e88cc46940bb262add13");
        call.enqueue(new Callback<AirQuality>() {
            @Override
            public void onResponse(Call<AirQuality> call, Response<AirQuality> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AirQuality airQuality = response.body();
                    updateUI(airQuality);
                } else {
                    Toast.makeText(ActivityVerification.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AirQuality> call, Throwable t) {
                Toast.makeText(ActivityVerification.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI(AirQuality airQuality) {
        TextView tvCo = findViewById(R.id.co);
        TextView tvNo = findViewById(R.id.no);
        TextView tvSo2 = findViewById(R.id.so2);
        TextView tvAqi = findViewById(R.id.aqi);
        TextView wtd = findViewById(R.id.wtd);
        ImageView imageView = findViewById(R.id.imageView);

        tvCo.setText("CO: " + airQuality.getCo());
        tvNo.setText("NO: " + airQuality.getNo());
        tvSo2.setText("SO2: " + airQuality.getSo2());
        tvAqi.setText("AQI: " + airQuality.getAqi());

        if(airQuality.getAqi() <= 2){
            wtd.setText("L'air est pur et sans danger pour la santé");
            imageView.setImageResource(R.drawable.cleanup);
        } else {
            wtd.setText("L'air est pollué et peut être dangereux pour la santé");
        }
    }
}