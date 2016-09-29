package com.rscottcarson.activeandroid_tutorial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.rscottcarson.activeandroid_tutorial.R;
import com.rscottcarson.activeandroid_tutorial.models.Body;
import com.rscottcarson.activeandroid_tutorial.models.Car;
import com.rscottcarson.activeandroid_tutorial.models.Engine;
import com.rscottcarson.activeandroid_tutorial.models.Wheel;
import com.rscottcarson.activeandroid_tutorial.models.model_builders.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int SERIAL_NUMBER = 12345678;

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);
        mTextView = (TextView) findViewById(R.id.tv1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCar();
            }
        });

        buildCar();
    }

    /**
     * Build the first car
     */
    private void buildCar(){
        // Set up our engine
        Engine e = new Engine();
        e.setCylinders(Engine.CYLINDERS_FOUR);
        e.setVolume(Engine.VOLUME_3_7_L);
        e.setFuelType(Engine.FUEL_TYPE_GAS);
        e.save();

        // Set up our car body
        Body b = new Body();
        b.setBodyStyle(Body.BODY_STYLE_SPORT);
        b.save();

        //Set up our wheels
        Wheel w = new Wheel();
        w.setRims(Wheel.RIMS_SPINNER);
        w.setTires(Wheel.TIRES_WRANGLER);
        w.save();

        // Use our Builder class to build a car
        CarBuilder cBuilder = new CarBuilder();
        Car mCar = cBuilder
                .addSerialNumber(SERIAL_NUMBER)
                .addBody(b)
                .addEngine(e)
                .addWheelsUniform(w)
                .build();

        mCar.save();

    }

    /**
     * Load a single car from the database
     */
    private void loadCar(){

        // Check if our Car saved correctly
        boolean exists =
                new Select()
                        .from(Car.class) // Specify the table to search
                        .where("serialNumber = ?", SERIAL_NUMBER) // search criteria
                        .exists(); // Simply ask if it exists

        if(exists) {

            // Load the car from the database
            Car mCar =
                    new Select()
                            .from(Car.class) // Specify the table to search
                            .where("serialNumber = ?", SERIAL_NUMBER) // search criteria
                            .executeSingle(); // return only the first match

            // Set the TextView to display the formatted json object
            mTextView.setText(formatString(mCar.getJsonObject().toString()));
        }
        else{
            Log.e(TAG, "loadCar car " + SERIAL_NUMBER + " does not exist!");
        }
    }

    /**
     * Take a Json string and format it to display nicely
     * @param text
     * @return
     */
    public static String formatString(String text){

        StringBuilder json = new StringBuilder();
        String indentString = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            switch (letter) {
                case '{':
                case '[':
                    json.append("\n" + indentString + letter + "\n");
                    indentString = indentString + "\t";
                    json.append(indentString);
                    break;
                case '}':
                case ']':
                    indentString = indentString.replaceFirst("\t", "");
                    json.append("\n" + indentString + letter);
                    break;
                case ',':
                    json.append(letter + "\n" + indentString);
                    break;

                default:
                    json.append(letter);
                    break;
            }
        }

        return json.toString();
    }
}
