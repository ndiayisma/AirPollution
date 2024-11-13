package com.example.airpollution;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<City> cityList;
    //private Context context;

    public CityAdapter(List<City> cityList) {
        this.cityList = cityList;
        //this.context = context;
    }


    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CityViewHolder viewHolder;
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        viewHolder = new CityViewHolder(View);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cityList.get(position);
        holder.titre.setText(city.getName());
        holder.latitude.setText(String.valueOf(city.getLat()));
        holder.longitude.setText(String.valueOf(city.getLon()));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView titre, latitude, longitude;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            latitude = itemView.findViewById(R.id.latitude);
            longitude = itemView.findViewById(R.id.longitude);
        }
    }
}