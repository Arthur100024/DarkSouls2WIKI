package com.karapetyan.darksoulswiki.UI.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.karapetyan.darksoulswiki.UI.Data.Models.LocationsModel;
import com.karapetyan.darksoulswiki.UI.Data.repository.LocationsRepository;

import java.util.List;

public class NeededLocationViewModel extends ViewModel {
    private final LocationsRepository locationsRepository = new LocationsRepository();

    public LiveData<LocationsModel> getNeededLocation(String title){
        return locationsRepository.getNeededLoc(title);
    }
}