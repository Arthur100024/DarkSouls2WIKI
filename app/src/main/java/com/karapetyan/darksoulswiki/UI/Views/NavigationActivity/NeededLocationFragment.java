package com.karapetyan.darksoulswiki.UI.Views.NavigationActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.UI.ViewModels.NeededLocationViewModel;
import com.karapetyan.darksoulswiki.databinding.FragmentNeededLocationBinding;

public class NeededLocationFragment extends Fragment {

    private NeededLocationViewModel mViewModel;
    FragmentNeededLocationBinding binding;

    public static NeededLocationFragment newInstance() {
        return new NeededLocationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentNeededLocationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new LocationsFragment());
            }
        });
    }
        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NeededLocationViewModel.class);

        Bundle bundle = this.getArguments();
        String title = bundle.getString("title");

        mViewModel.getNeededLocation(title).observe(getViewLifecycleOwner(), new Observer<LocationsModel>() {
            @Override
            public void onChanged(LocationsModel locationsModel) {
                binding.title.setText(locationsModel.getName());
                binding.desc.setText(locationsModel.getDescription());
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