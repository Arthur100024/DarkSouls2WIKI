package com.karapetyan.darksoulswiki.UI.Data.Models;

public class PersonsModel {
    private long id;
    private String name;
    private String description;

    public PersonsModel(){}

    public PersonsModel(long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
