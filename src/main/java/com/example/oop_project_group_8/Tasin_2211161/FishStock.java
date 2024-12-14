package com.example.oop_project_group_8.Tasin_2211161;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class FishStock {

    private final StringProperty species;
    private final StringProperty tank;
    private final IntegerProperty count;


    public FishStock(String species, String tank, int count) {
        this.species = new SimpleStringProperty(species);
        this.tank = new SimpleStringProperty(tank);
        this.count = new SimpleIntegerProperty(count);
    }


    public String getSpecies() {
        return species.get();
    }

    public String getTank() {
        return tank.get();
    }

    public int getCount() {
        return count.get();
    }


    public StringProperty speciesProperty() {
        return species;
    }

    public StringProperty tankProperty() {
        return tank;
    }

    public IntegerProperty countProperty() {
        return count;
    }
}
