package com.karapetyan.darksoulswiki.UI.Data.Models;

import android.content.res.Resources;
import android.net.Uri;

import java.util.Objects;

public class LocationsModel {
    private long id;
    private String name;
    private int image;

    public LocationsModel(){}

    public LocationsModel(String name, int image){
        this.id = id;
        this.name = name;
        this.image = image;
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

    public int getImage() {
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
