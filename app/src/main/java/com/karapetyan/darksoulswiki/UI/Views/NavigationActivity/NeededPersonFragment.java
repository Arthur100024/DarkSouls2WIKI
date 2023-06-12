package com.karapetyan.darksoulswiki.UI.Views.NavigationActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Data.Models.PersonsModel;
import com.karapetyan.darksoulswiki.UI.ViewModels.NeededPersonViewModel;
import com.karapetyan.darksoulswiki.databinding.FragmentNeededPersonBinding;

public class NeededPersonFragment extends Fragment {
    private NeededPersonViewModel mViewModel;
    FragmentNeededPersonBinding binding;

    public static NeededPersonFragment newInstance() {
        return new NeededPersonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentNeededPersonBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PersonsFragment());
            }
        });
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NeededPersonViewModel.class);

        Bundle bundle = this.getArguments();
        String name = bundle.getString("name");

        mViewModel.getNeededPerson(name).observe(getViewLifecycleOwner(), new Observer<PersonsModel>() {
            @Override
            public void onChanged(PersonsModel personsModel) {
                binding.name.setText(personsModel.getName());
                binding.desc.setText(personsModel.getDescription());
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameNavigation, fragment);
        ft.commit();
    }}