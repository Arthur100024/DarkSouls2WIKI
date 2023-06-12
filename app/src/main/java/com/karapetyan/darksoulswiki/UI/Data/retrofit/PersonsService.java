package com.karapetyan.darksoulswiki.UI.Data.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonsService {
    @GET("persons/{name}")
    Call<PersonsApi> showNeededPerson(@Path("name") String name);

    @GET("persons")
    Call<List<PersonsApi>> showPersons();
}

