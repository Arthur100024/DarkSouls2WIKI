package com.karapetyan.darksoulswiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.karapetyan.darksoulswiki.databinding.ActivityAuthBinding;
import com.karapetyan.darksoulswiki.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    ActivityNavigationBinding binding;

    public static SharedPreferences sharedPrefs;
    public static final String LOGGED = "IsUserLogged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPrefs = getSharedPreferences("prefs",MODE_PRIVATE);

        setUserLogged();    //Устанавливаем что юзер заходил


    }

    public void setUserLogged(){
        SharedPreferences.Editor editorLogged = sharedPrefs.edit();
        editorLogged.putString(LOGGED,"Yes");
        editorLogged.apply();
    }












    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameAuth, fragment);
        ft.commit();
    }
}