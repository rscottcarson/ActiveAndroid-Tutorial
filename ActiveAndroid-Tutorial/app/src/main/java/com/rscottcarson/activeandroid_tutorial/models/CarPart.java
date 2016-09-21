package com.rscottcarson.activeandroid_tutorial.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonObject;

/**
 * Created by scottcarson on 9/13/16.
 */
@Table(name = CarPart.TABLE_NAME, id = BaseColumns._ID)
public class CarPart extends Model {

    public static final String TABLE_NAME = "CarPart";

    public CarPart(){
        super();
    }

    public JsonObject getJsonObject(){
        return null;
    }
}
