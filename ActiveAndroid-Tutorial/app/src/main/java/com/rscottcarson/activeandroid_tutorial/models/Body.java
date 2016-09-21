package com.rscottcarson.activeandroid_tutorial.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonObject;

/**
 * Created by scottcarson on 9/14/16.
 */
@Table(name = Body.TABLE_NAME)
public class Body extends CarPart {

    public static final String TABLE_NAME = "Bodies";

    private static final String COLUMN_BODYSTYLE = "bodyStyle";

    @Column(name = COLUMN_BODYSTYLE)
    private static int bodyStyle;

    public Body(){
        super();
    }

    // Getters and Setters

    public static int getBodyStyle() {
        return bodyStyle;
    }

    public static void setBodyStyle(int _bodyStyle) {
        Body.bodyStyle = _bodyStyle;
    }

    @Override
    public JsonObject getJsonObject(){
        JsonObject obj = new JsonObject();

        obj.addProperty(COLUMN_BODYSTYLE, bodyStyle);

        return obj;
    }
}
