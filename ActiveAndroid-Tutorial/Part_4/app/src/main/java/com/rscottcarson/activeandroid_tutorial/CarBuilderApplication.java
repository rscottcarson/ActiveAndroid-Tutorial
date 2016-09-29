package com.rscottcarson.activeandroid_tutorial;

import com.activeandroid.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by scottcarson on 9/21/16.
 */
public class CarBuilderApplication extends Application {

    private Gson gson;

    @Override
    public void onCreate(){
        super.onCreate();

        GsonBuilder gBuilder = new GsonBuilder();

        gson = gBuilder.create();
    }
}
