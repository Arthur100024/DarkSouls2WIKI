package com.karapetyan.darksoulswiki.UI.Data.Models;

import android.content.res.Resources;
import android.net.Uri;

import java.util.Objects;

public class LocationsModel {
    private long id;
    private String name;
    private String description;

    public LocationsModel(){}

    public LocationsModel(long id, String name, String description){
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
