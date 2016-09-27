package com.rscottcarson.activeandroid_tutorial.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonObject;

/**
 * Created by scottcarson on 9/14/16.
 */
@Table(name = Wheel.TABLE_NAME)
public class Wheel extends CarPart {

    public static final String RIMS_SPINNER = "spinner";
    public static final String TIRES_WRANGLER = "Goodyear wrangler";

    public static final String TABLE_NAME = "Wheels";

    private static final String COLUMN_RIMS = "rims";
    private static final String COLUMN_TIRES = "tires";

    @Column(name = COLUMN_RIMS)
    private String rims;

    @Column(name = COLUMN_TIRES)
    private String tires;

    // Mandatory no-arg constructor
    public Wheel(){
        super();
    }

    // Getters and Setters
    public String getRims() {
        return rims;
    }

    public void setRims(String _rims) {
        rims = _rims;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String _tires) {
        tires = _tires;
    }

    @Override
    public JsonObject getJsonObject(){
        JsonObject obj = new JsonObject();

        obj.addProperty(COLUMN_RIMS, rims);
        obj.addProperty(COLUMN_TIRES, tires);

        return obj;
    }
}
