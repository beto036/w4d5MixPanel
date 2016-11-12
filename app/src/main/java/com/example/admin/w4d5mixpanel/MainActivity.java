package com.example.admin.w4d5mixpanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String YOUR_PROJECT_TOKEN = "97fe7f5aae4779828ef05536e916471b";
    private MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = YOUR_PROJECT_TOKEN; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
        mixpanel = MixpanelAPI.getInstance(this, projectToken);
    }

    public void send(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", false);
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }
}
