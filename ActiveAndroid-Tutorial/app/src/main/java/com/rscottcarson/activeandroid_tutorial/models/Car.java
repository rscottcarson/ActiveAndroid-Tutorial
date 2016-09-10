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

    public static final String CAR_TABLE_NAME = "car_table";

    private static final String COLUMN_TIRE = "tire";

    @Column(name = COLUMN_TIRE)
    private int tire;
}
