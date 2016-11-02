package com.rscottcarson.activeandroid_tutorial.type_serializers;

import android.util.Log;

import com.activeandroid.serializer.TypeSerializer;
import com.rscottcarson.activeandroid_tutorial.CarBuilderApplication;
import com.rscottcarson.activeandroid_tutorial.models.Wheel;
import com.rscottcarson.activeandroid_tutorial.models.gson_types.GetWheelList;

import java.util.List;

/**
 * Created by scottcarson on 9/29/16.
 */
public class ListTypeSerializer extends TypeSerializer {

    private static final String TAG = ListTypeSerializer.class.getSimpleName();


    @Override
    public Class<?> getDeserializedType() {
        return List.class;
    }


    @Override
    public Class<?> getSerializedType() {
        return String.class;
    }


    @Override
    public String serialize(Object data) {

        Log.i(TAG, "in serialize");

        StringBuilder sBuilder = new StringBuilder();

        // If we succesfully convert it to a String, print out the resulting string,
        // otherwise print an error
        if(getListAsJsonString(data, sBuilder)){
            Log.i(TAG, "serialize: " + sBuilder.toString());
        }
        else{
            Log.e(TAG, "Error ");
        }

        return sBuilder.toString();
    }


    /**
     * Helper function to build the Serialized Json String of our wheel list. It is written
     * in such a way that we could potentially add more List<T> types other than List<Wheel>
     * @param o data Object
     * @param sBuilder Reference to stringbuilder
     * @return False if the object is not a supported List<T> type
     */
    private boolean getListAsJsonString(Object o, StringBuilder sBuilder){

        if(o instanceof List){
            Log.i(TAG, "getListType is a List");

            List<?> list = (List<?>) o;

            if(!list.isEmpty()){
                Object type = list.get(0);

                if(type instanceof Wheel){
                    List<Wheel> finalList = (List<Wheel>) list;
                    sBuilder.append("{\"")
                            .append("wheelList")
                            .append("\":")
                            .append(finalList.toString())
                            .append("}");
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public List<?> deserialize(Object data) {

        Log.i(TAG, "in deserialize");

        String s = (String) data;

        // Get our wheelList using our global gson instance
        if(s.contains("wheelList")){
            GetWheelList gwl = CarBuilderApplication
                    .getApp()
                    .getGson()
                    .fromJson(s, GetWheelList.class);

            return gwl.wheelList;
        }
        else {
            return null;
        }
    }


}
