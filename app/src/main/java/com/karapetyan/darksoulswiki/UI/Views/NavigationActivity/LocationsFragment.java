package com.karapetyan.darksoulswiki.UI.Views.NavigationActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Adapters.LocationsAdapter;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.databinding.FragmentLocationsBinding;

import java.util.ArrayList;

public class LocationsFragment extends Fragment {

    FragmentLocationsBinding binding;
    private ArrayList<LocationsModel> locations = new ArrayList<LocationsModel>();
    LocationsAdapter adapter;

    public static LocationsFragment newInstance() {
        return new LocationsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLocationsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setData();
        LocationsAdapter adapter = new LocationsAdapter(this.getContext(), locations);
        binding.recyclerLocations.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerLocations.setAdapter(adapter);
    }

    private void setData(){
        locations.add(new LocationsModel("Interworld", R.drawable.ds2_interworld));
        locations.add(new LocationsModel("Archie", R.drawable.ic_launcher_foreground));
    }
}