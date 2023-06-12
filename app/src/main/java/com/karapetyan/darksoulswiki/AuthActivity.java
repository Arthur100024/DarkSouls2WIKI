package com.karapetyan.darksoulswiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.karapetyan.darksoulswiki.UI.Views.AuthActivity.SignInFragment;
import com.karapetyan.darksoulswiki.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    ActivityAuthBinding binding;

    public static SharedPreferences sharedPrefs;
    public static final String LOGGED = "IsUserLogged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPrefs = getSharedPreferences("prefs",MODE_PRIVATE);

        try {
            checkUserLogged();  //Проверяем заходил ли юзер ранее
        } catch (Exception e){
            replaceFragment(new SignInFragment());
        }
    }

    public void checkUserLogged(){
        if (sharedPrefs.getString(LOGGED, null).equals("Yes")){
            changeActivity(".NavigationActivity");
        } else {
            replaceFragment(new SignInFragment());
        }
    }










    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameAuth, fragment);
        ft.commit();
    }

    public void changeActivity(String name_of_activity){
        Intent changeMyActivity = new Intent(name_of_activity);
        startActivity(changeMyActivity);
    }
}