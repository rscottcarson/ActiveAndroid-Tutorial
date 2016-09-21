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

    public static final String TABLE_NAME = "Engines";

    private static final String COLUMN_VOLUME = "volume";
    private static final String COLUMN_CYLINDERS = "cylinders";
    private static final String COLUMN_GASTYPE = "gasType";

    @Column(name = COLUMN_VOLUME)
    private double volume;

    @Column(name = COLUMN_CYLINDERS)
    private int cylinders;

    @Column(name = COLUMN_GASTYPE)
    private String gasType;

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

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String _gasType) {
        gasType = _gasType;
    }

    @Override
    public JsonObject getJsonObject(){
        JsonObject obj = new JsonObject();

        obj.addProperty(COLUMN_VOLUME, volume);
        obj.addProperty(COLUMN_CYLINDERS, cylinders);
        obj.addProperty(COLUMN_GASTYPE, gasType);

        return obj;
    }
}
