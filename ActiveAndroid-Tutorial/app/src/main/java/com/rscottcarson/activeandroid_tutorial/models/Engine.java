package com.rscottcarson.activeandroid_tutorial.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonObject;

/**
 * Created by scottcarson on 9/13/16.
 */
@Table(name = Engine.TABLE_NAME)
public class Engine extends CarPart {

    public static final String FUEL_TYPE_GAS = "gas";
    public static final int CYLINDERS_FOUR = 4;
    public static final double VOLUME_3_7_L = 3.7;

    public static final String TABLE_NAME = "Engines";

    private static final String COLUMN_VOLUME = "volume";
    private static final String COLUMN_CYLINDERS = "cylinders";
    private static final String COLUMN_FUELTYPE = "fuelType";

    @Column(name = COLUMN_VOLUME)
    private double volume;

    @Column(name = COLUMN_CYLINDERS)
    private int cylinders;

    @Column(name = COLUMN_FUELTYPE)
    private String fuelType;

    // Mandatory no-arg constructor
    public Engine(){
        super();
    }

    // Getters and Setters
    public double getVolume() {
        return volume;
    }

    public void setVolume(double _volume) {
        volume = _volume;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int _cylinders) {
        cylinders = _cylinders;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String _fuelType) {
        fuelType = _fuelType;
    }

    @Override
    public JsonObject getJsonObject(){
        JsonObject obj = new JsonObject();

        obj.addProperty(COLUMN_VOLUME, volume);
        obj.addProperty(COLUMN_CYLINDERS, cylinders);
        obj.addProperty(COLUMN_FUELTYPE, fuelType);

        return obj;
    }
}
