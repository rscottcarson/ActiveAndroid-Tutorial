package com.rscottcarson.activeandroid_tutorial;

import com.activeandroid.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

/**
 * Created by scottcarson on 9/21/16.
 */
public class CarBuilderApplication extends Application {

    private static CarBuilderApplication sInstance;

    private Gson gson;

    @Override
    public void onCreate(){
        super.onCreate();

        // build new gson instance
        gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .create();

        sInstance = this;
    }

    /**
     * Get global gson instance
     * @return
     */
    public Gson getGson(){
        return gson;
    }

    /**
     * Restrict access to the app through a static instance
     * @return
     */
    public static CarBuilderApplication getApp(){
        return sInstance;
    }
}
