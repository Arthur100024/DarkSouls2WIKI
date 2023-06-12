package com.karapetyan.darksoulswiki.UI.Data.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocationsService {
    @GET("locations/{title}")
    Call<LocationsApi> showNeededLocation(@Path("title") String title);

    @GET("locations")
    Call<List<LocationsApi>> showLocations();
}

