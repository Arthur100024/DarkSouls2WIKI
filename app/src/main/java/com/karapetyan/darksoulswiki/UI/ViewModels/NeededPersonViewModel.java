package com.karapetyan.darksoulswiki.UI.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.karapetyan.darksoulswiki.UI.Data.Models.PersonsModel;
import com.karapetyan.darksoulswiki.UI.Data.repository.PersonsRepository;

public class NeededPersonViewModel extends ViewModel {
    private final PersonsRepository personsRepository = new PersonsRepository();

    public LiveData<PersonsModel> getNeededPerson(String name){
        return personsRepository.getNeededPerson(name);
    }
}