package com.karapetyan.darksoulswiki.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;

import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<LocationsModel> locations;



    public LocationsAdapter(Context context, List<LocationsModel> locations) {
        this.locations = locations;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_locations, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocationsModel model = locations.get(position);
        holder.nameLocationsList.setText(model.getName());
        holder.imageLocationsList.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameLocationsList;
        ImageView imageLocationsList;

        public ViewHolder(View view) {
            super(view);
            nameLocationsList = view.findViewById(R.id.nameLocationsList);
            imageLocationsList = view.findViewById(R.id.imageLocationsList);
        }

    }

}
