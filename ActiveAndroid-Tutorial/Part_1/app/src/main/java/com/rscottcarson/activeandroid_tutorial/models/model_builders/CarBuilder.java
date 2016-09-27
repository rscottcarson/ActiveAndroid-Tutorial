package com.rscottcarson.activeandroid_tutorial.models.model_builders;

import com.rscottcarson.activeandroid_tutorial.models.Body;
import com.rscottcarson.activeandroid_tutorial.models.Car;
import com.rscottcarson.activeandroid_tutorial.models.Engine;
import com.rscottcarson.activeandroid_tutorial.models.Wheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottcarson on 9/21/16.
 */
public class CarBuilder {

    private static final String TAG = CarBuilder.class.getSimpleName();

    private Car mCar;

    public CarBuilder(){
        mCar = new Car();
    }

    public CarBuilder addEngine(Engine engine){
        mCar.setEngine(engine);

        return this;
    }

    public CarBuilder addBody(Body body){
        mCar.setBody(body);

        return this;
    }

    public CarBuilder addWheelsUniform(Wheel wheel){
        List<Wheel> wheels = new ArrayList<>();

        wheels.add(wheel);
        wheels.add(wheel);
        wheels.add(wheel);
        wheels.add(wheel);

        mCar.setWheels(wheels);

        return this;
    }

    public CarBuilder addSerialNumber(int serialNumber){
        mCar.setSerialNumber(serialNumber);

        return this;
    }

    public Car build(){
        return mCar;
    }
}
