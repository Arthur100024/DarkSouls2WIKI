package com.karapetyan.darksoulswiki.UI.Views.NavigationActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Adapters.LocationsAdapter;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.UI.ViewModels.LocationsViewModel;
import com.karapetyan.darksoulswiki.databinding.FragmentLocationsBinding;

import java.util.ArrayList;
import java.util.List;

public class LocationsFragment extends Fragment {

    FragmentLocationsBinding binding;
    private ArrayList<LocationsModel> locations = new ArrayList<LocationsModel>();
    LocationsAdapter adapter;
    private LocationsViewModel viewModel;

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
        LocationsAdapter adapter = new LocationsAdapter(this.getContext(), locations);
        binding.recyclerLocations.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerLocations.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(LocationsViewModel.class);


        viewModel.getLocation().observe(getViewLifecycleOwner(), new Observer<List<LocationsModel>>() {
            @Override
            public void onChanged(List<LocationsModel> locationsModels) {
                adapter.setLocations(locationsModels);
                System.out.println(locationsModels.get(0).getName());
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MenuFragment());
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameNavigation, fragment);
        ft.commit();
    }

}