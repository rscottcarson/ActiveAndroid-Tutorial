package com.rscottcarson.activeandroid_tutorial.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by scottcarson on 9/9/16.
 */
@Table(name = Car.CAR_TABLE_NAME, id = BaseColumns._ID)
public class Car extends Model {

    // Declare table name as public
    public static final String CAR_TABLE_NAME = "car_table";

    // Declare all column names private
    private static final String COLUMN_ENGINE = "engine";
    private static final String COLUMN_BODY = "body";
    private static final String COLUMN_WHEEL = "wheels";
    private static final String COLUMN_SERIAL_NUMBER = "serial_number";

    @Column(name = COLUMN_ENGINE)
    private Engine engine;

    @Column(name = COLUMN_BODY)
    private int body;

    @Column(name = COLUMN_WHEEL)
    private int wheels;

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

    public int getBody() {
        return body;
    }

    public void setBody(int _body) {
        body = _body;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int _wheels) {
        wheels = _wheels;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int _serialNumber) {
        serialNumber = _serialNumber;
    }


}
