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
import com.karapetyan.darksoulswiki.databinding.FragmentPersonsBinding;

import java.util.ArrayList;
import java.util.List;

public class PersonsFragment extends Fragment {

    FragmentPersonsBinding binding;

    public static PersonsFragment newInstance() {
        return new PersonsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPersonsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameNavigation, fragment);
        ft.commit();
    }

}