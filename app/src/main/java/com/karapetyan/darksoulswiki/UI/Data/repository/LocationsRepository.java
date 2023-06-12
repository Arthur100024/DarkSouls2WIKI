package com.karapetyan.darksoulswiki.UI.Data.repository;

import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.UI.Data.retrofit.LocationsApi;
import com.karapetyan.darksoulswiki.UI.Data.retrofit.LocationsService;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationsRepository {
    MutableLiveData<List<LocationsModel>> list = new MutableLiveData<>();
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.56.1:8080/api/")
            .build();
    private LocationsService locationsService = retrofit.create(LocationsService.class);

    public LiveData<List<LocationsModel>> getAllLocations(){

        MutableLiveData<List<LocationsModel>> result = new MutableLiveData<>();

        locationsService.showLocations().enqueue(new Callback<List<LocationsApi>>() {
            @Override
            public void onResponse(Call<List<LocationsApi>> call, Response<List<LocationsApi>> response) {
                if(response.isSuccessful()){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        result.setValue(response.body().stream().map(l -> {
                            LocationsModel locationsModel = new LocationsModel();
                            locationsModel.setName(l.title);
                            locationsModel.setDescription(l.description);
                            System.out.println(locationsModel.getDescription());
                            return locationsModel;
                        }).collect(Collectors.toList()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<LocationsApi>> call, Throwable t) {

            }
        });
        return result;
    }

    public LiveData<LocationsModel> getNeededLoc(String title){
        MutableLiveData<LocationsModel> resultNeed = new MutableLiveData<>();

        locationsService.showNeededLocation(title).enqueue(new Callback<LocationsApi>() {
            @Override
            public void onResponse(Call<LocationsApi> call, Response<LocationsApi> response) {
                if (response.isSuccessful()){
                    LocationsModel locationsModel = new LocationsModel();
                    locationsModel.setId(response.body().id);
                    locationsModel.setName(response.body().title);
                    locationsModel.setDescription(response.body().description);
                    resultNeed.setValue(locationsModel);
                }
            }

            @Override
            public void onFailure(Call<LocationsApi> call, Throwable t) {

            }
        });
        return resultNeed;
    }
}
