package com.example.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import com.example.myapp.R;
import com.example.myapp.activity.buildingriskanalysis.BuildingRiskAnalysisMainActivity;
import com.example.myapp.activity.floodIndentation.FloodIndentationActivity;
import com.example.myapp.activity.harvestingtool.HarvestingTechniquesActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        Button floodIndundation = findViewById(R.id.floodInduntation);
        Button buildingriskanalysis = findViewById(R.id.buildingriskanalysis);
        Button harvestigTechniques = findViewById(R.id.harvestingTechniques);
        floodIndundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callFloodInduntationActivity();
            }
        });

        buildingriskanalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBuildingRiskAnalysisActivity();
            }
        });

        harvestigTechniques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callHarvestingTechniquesActivity();
            }
        });
    }

    private void callFloodInduntationActivity() {
        Intent intent = new Intent(this, FloodIndentationActivity.class);
        startActivity(intent);
    }

    private void callBuildingRiskAnalysisActivity() {
        Intent intent = new Intent(this, BuildingRiskAnalysisMainActivity.class);
        startActivity(intent);
    }

    private void callHarvestingTechniquesActivity() {
        Intent intent = new Intent(this, HarvestingTechniquesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
