package com.rscottcarson.activeandroid_tutorial.models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by scottcarson on 9/9/16.
 */
@Table(name = Car.TABLE_NAME)
public class Car extends Model {

    // Declare table name as public
    public static final String TABLE_NAME = "Cars";

    // Declare all column names private
    private static final String COLUMN_ENGINE = "engine";
    private static final String COLUMN_BODY = "body";
    private static final String COLUMN_WHEEL = "wheels";
    private static final String COLUMN_SERIAL_NUMBER = "serialNumber";

    @Column(name = COLUMN_ENGINE)
    private Engine engine;

    @Column(name = COLUMN_BODY)
    private Body body;

    @Column(name = COLUMN_WHEEL)
    private List<Wheel> wheels;

    @Column(name = COLUMN_SERIAL_NUMBER, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int serialNumber;

    // Mandatory no arg constructor
    public Car(){
        super();
    }

    // Getters and setters
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine _engine) {
        engine = _engine;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body _body) {
        body = _body;
    }

    public List<Wheel>  getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel>  _wheels) {
        wheels = _wheels;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int _serialNumber) {
        serialNumber = _serialNumber;
    }

    private JsonArray getWheelsList(){
        JsonArray arr = new JsonArray();

        for(Wheel w : wheels){
            arr.add(w.getJsonObject());
        }

        return arr;
    }

    public JsonObject getJsonObject(){

        JsonObject car = new JsonObject();
        JsonObject obj = new JsonObject();

        obj.addProperty(COLUMN_SERIAL_NUMBER, serialNumber);
        obj.add(COLUMN_ENGINE, engine.getJsonObject());
        obj.add(COLUMN_BODY, body.getJsonObject());
        //obj.add(COLUMN_WHEEL, getWheelsList()); // TODO: Implement TypeSerializer for List<>

        car.add("Car", obj);

        return car;
    }

}
