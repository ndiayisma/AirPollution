/*package com.example.airpollution;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    public CityAdapter(List<City> cityList, Context context) {
        this.cityList = cityList;
        this.context = context;
    }

    private List<City> cityList;
    private Context context;

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /*public class CityViewHolder extends RecyclerView.ViewHolder {

    }
}*/