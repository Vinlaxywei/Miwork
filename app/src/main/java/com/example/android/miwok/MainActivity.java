package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
