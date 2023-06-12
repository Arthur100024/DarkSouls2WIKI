package com.karapetyan.darksoulswiki.UI.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.karapetyan.darksoulswiki.UI.Data.Models.PersonsModel;
import com.karapetyan.darksoulswiki.UI.Data.repository.PersonsRepository;

import java.util.List;

public class PersonsViewModel extends ViewModel {

    private final PersonsRepository personsRepository = new PersonsRepository();

    public LiveData<List<PersonsModel>> getPerson(){
        return personsRepository.getAllPersons();
    }

}
