package com.karapetyan.darksoulswiki.UI.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.UI.Views.NavigationActivity.NeededLocationFragment;

import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<LocationsModel> locations;
    private Context context;

    Bundle bundle;

    public LocationsAdapter(Context context, List<LocationsModel> locations) {
        this.locations = locations;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
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

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("title", String.valueOf(holder.nameLocationsList.getText()));
                replaceFragment(new NeededLocationFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameLocationsList;
        Button button;

        public ViewHolder(View view) {
            super(view);
            nameLocationsList = view.findViewById(R.id.nameLocationsList);
            button = view.findViewById(R.id.applyBtn);
        }
    }

    public void setLocations(List<LocationsModel> locations){
        this.locations = locations;
        notifyDataSetChanged();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment.setArguments(bundle);
        ft.replace(R.id.frameNavigation, fragment);
        ft.commit();
    }
}
