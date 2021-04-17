package com.example.petneeds.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PetInfo {
    String name;
    String vicinity;

    public PetInfo(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        vicinity = jsonObject.getString("vicinity");

    }


    public  static List<PetInfo> fromJsonArray(JSONArray petJsonArray) throws JSONException {
        List<PetInfo> info = new ArrayList<>();
        for(int i = 0; i< petJsonArray.length();i++){
            info.add(new PetInfo(petJsonArray.getJSONObject(i)));
        }
        return info;
    }

    public String getName() {
        return name;
    }

    public String getVicinity() {
        return vicinity;
    }
}
