package com.example.petneeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.petneeds.adapters.PetAdapter;
import com.example.petneeds.models.PetInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

        public static final String PET_INFORMATION = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=32.776665,-96.796989\n" +
                "&radius=1500&type=pet_store&key=AIzaSyA3eIDiQk5MNmPvyx62qERmyb54UzORsIg";

        public static final String TAG ="MainActivity";

    List<PetInfo> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPetDetails = findViewById(R.id.rvPetDetails);


        info = new ArrayList<>();
        final PetAdapter petAdapter = new PetAdapter(this, info);

        rvPetDetails.setAdapter(petAdapter);

        rvPetDetails.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(PET_INFORMATION, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                JSONObject jsonObject = new JSONObject();
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG, "RESULTS:" + results.toString());
                    info.addAll(PetInfo.fromJsonArray(results));
                    petAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {

            }
        });

    }
}