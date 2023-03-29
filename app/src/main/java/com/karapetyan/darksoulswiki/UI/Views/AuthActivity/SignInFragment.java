package com.karapetyan.darksoulswiki.UI.Views.AuthActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.databinding.FragmentSignInBinding;

public class SignInFragment extends Fragment {

    FragmentSignInBinding binding;
    boolean isHided = true;

    public static SignInFragment newInstance() {return new SignInFragment();}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.hidePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHided){
                    binding.passwordSignInEt.setTransformationMethod(null);
                } else {
                    binding.passwordSignInEt.setTransformationMethod(new PasswordTransformationMethod());
                }
                isHided = !isHided;
                binding.passwordSignInEt.setSelection(binding.passwordSignInEt.length());
            }
        });

        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(".NavigationActivity");
            }
        });

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SignUpFragment());
            }
        });

        binding.noSignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new NoAccAttentionFragment());
            }
        });
    }

    public void changeActivity(String name_of_activity){
        Intent changeMyActivity = new Intent(name_of_activity);
        startActivity(changeMyActivity);
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameAuth, fragment);
        ft.commit();
    }



}