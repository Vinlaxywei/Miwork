package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> restaurantsToTry = new ArrayList<>();
        restaurantsToTry.add(0,"Morning Cofe");
        restaurantsToTry.add(1,"BBQ Time");
        restaurantsToTry.size();
        Log.d("main",restaurantsToTry.size()+restaurantsToTry.get(1));
    }

    public void startNumbersActivity(View v) {
        startActivity(new Intent(getBaseContext(),NumbersActivity.class));
    }

    public void startFamilyActivity(View v) {
        startActivity(new Intent(getBaseContext(),FamilyActivity.class));
    }

    public void startColorsActivity(View v) {
        startActivity(new Intent(getBaseContext(),ColorsActivity.class));
    }

    public void startPhrasesActivity(View v) {
        startActivity(new Intent(getBaseContext(),PhrasesActivity.class));
    }

}
