package com.example.airpollution;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airpollution.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private OpenWeatherServices openWeatherServices;
    private List<City> cityList;
    private CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialiser la liste des villes
        cityList = new ArrayList<>();
        cityList.add(new City("London", 51.5085, -0.1257));
        cityList.add(new City("Paris", 48.8566, 2.3522));

        // Set up RecyclerView
        RecyclerView recyclerViewCity = binding.recyclerViewCity;
        recyclerViewCity.setLayoutManager(new LinearLayoutManager(this));
        cityAdapter = new CityAdapter(cityList);
        recyclerViewCity.setAdapter(cityAdapter);

        /* Configurer le Spinner
        Spinner spinnerCity = binding.spinnerCity;
        ArrayAdapter<City> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                City selectedCity = (City) parent.getItemAtPosition(position);
                fetchAirQualityData(selectedCity.getLat(), selectedCity.getLon());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });*/
    }

    private void fetchAirQualityData(double lat, double lon) {
        OpenWeatherServices service = RetrofitClientInstance.getRetrofitInstance().create(OpenWeatherServices.class);
        Call<City> call = service.getLondonCoord();
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.isSuccessful() && response.body() != null) {
                    City cityResponse = response.body();
                    updateUI(cityResponse);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI(City cityResponse) {
        RecyclerView recyclerViewCity = binding.recyclerViewCity;

        //tvCity.setText("City: " + airQualityResponse.getCoord().getLat() + ", " + airQualityResponse.getCoord().getLon());
        //tvLatitude.setText("Latitude: " + cityResponse.getCoord().getLat());
        //tvLongitude.setText("Longitude: " + cityResponse.getCoord().getLon());


    }
}