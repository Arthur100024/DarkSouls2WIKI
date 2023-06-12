package com.karapetyan.darksoulswiki.UI.Data.repository;

import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karapetyan.darksoulswiki.UI.Data.Models.PersonsModel;
import com.karapetyan.darksoulswiki.UI.Data.retrofit.PersonsApi;
import com.karapetyan.darksoulswiki.UI.Data.retrofit.PersonsService;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonsRepository {
    MutableLiveData<List<PersonsModel>> list = new MutableLiveData<>();
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.56.1:8080/api/")
            .build();
    private PersonsService personsService = retrofit.create(PersonsService.class);

    public LiveData<List<PersonsModel>> getAllPersons(){

        MutableLiveData<List<PersonsModel>> result = new MutableLiveData<>();

        personsService.showPersons().enqueue(new Callback<List<PersonsApi>>() {
            @Override
            public void onResponse(Call<List<PersonsApi>> call, Response<List<PersonsApi>> response) {
                if(response.isSuccessful()){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        result.setValue(response.body().stream().map(l -> {
                            PersonsModel personsModel = new PersonsModel();
                            personsModel.setName(l.name);
                            personsModel.setDescription(l.description);
                            System.out.println(personsModel.getDescription());
                            return personsModel;
                        }).collect(Collectors.toList()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PersonsApi>> call, Throwable t) {

            }
        });
        return result;
    }

    public LiveData<PersonsModel> getNeededPerson(String name){
        MutableLiveData<PersonsModel> resultNeed = new MutableLiveData<>();

        personsService.showNeededPerson(name).enqueue(new Callback<PersonsApi>() {
            @Override
            public void onResponse(Call<PersonsApi> call, Response<PersonsApi> response) {
                if (response.isSuccessful()){
                    PersonsModel personsModel = new PersonsModel();
                    personsModel.setId(response.body().id);
                    personsModel.setName(response.body().name);
                    personsModel.setDescription(response.body().description);
                    resultNeed.setValue(personsModel);
                }
            }

            @Override
            public void onFailure(Call<PersonsApi> call, Throwable t) {

            }
        });
        return resultNeed;
    }
}
