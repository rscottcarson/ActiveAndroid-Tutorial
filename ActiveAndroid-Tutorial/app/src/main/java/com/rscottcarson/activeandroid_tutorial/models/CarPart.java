package com.rscottcarson.activeandroid_tutorial.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;

/**
 * Created by scottcarson on 9/13/16.
 */
@Table(name = CarPart.CAR_PART_TABLE_NAME, id = BaseColumns._ID)
public class CarPart extends Model {

    public static final String CAR_PART_TABLE_NAME = "CarPart";

    public CarPart(){
        super();
    }
}
