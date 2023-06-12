package com.karapetyan.darksoulswiki.UI.Views.NavigationActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Adapters.LocationsAdapter;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.databinding.FragmentLocationsBinding;
import com.karapetyan.darksoulswiki.databinding.FragmentMenuBinding;

import java.util.ArrayList;


public class MenuFragment extends Fragment {

    FragmentMenuBinding binding;
//    private ArrayList<LocationsModel> locations = new ArrayList<LocationsModel>();


    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        LocationsAdapter adapter = new LocationsAdapter(this.getContext(), locations);
//        binding.recyclerMenu.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        binding.recyclerMenu.setAdapter(adapter);

        binding.locationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new LocationsFragment());
            }
        });

        binding.personsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PersonsFragment());
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