package com.example.airpollution;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<City> cityList;
    private Context context;

    public CityAdapter(List<City> cityList, Context context) {
        this.cityList = cityList;
        this.context = context;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cityList.get(position);
        holder.bind(city);
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView titre;
        private TextView latitude;
        private TextView longitude;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.city);
            latitude = itemView.findViewById(R.id.latitude);
            longitude = itemView.findViewById(R.id.longitude);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    City city = cityList.get(position);
                    Intent intent = new Intent(context, ActivityVerification.class);
                    intent.putExtra("cityName", city.getName());
                    intent.putExtra("latitude", city.getLat());
                    intent.putExtra("longitude", city.getLon());
                    context.startActivity(intent);
                }
            });
        }

        public void bind(City city) {
            titre.setText(city.getName());
            latitude.setText("Latitude: " + city.getLat());
            longitude.setText("Longitude: " + city.getLon());
        }
    }
}