package com.example.myapp.activity.buildingriskanalysis;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.model.BuildingRiskAnalysisUserData;
import com.example.myapp.model.FloodIndentationUserData;

import java.io.File;

public class BuildingRiskAnalysisFinalActivity extends AppCompatActivity {

    private EditText buildingriskanalysis;
    BuildingRiskAnalysisUserData buildingRiskAnalysisUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildingRiskAnalysisUserData = (BuildingRiskAnalysisUserData) getIntent()
                .getSerializableExtra("buildingRiskAnalysisUserData");
        setContentView(R.layout.activity_buildingriskanalysisfinal);
        displayResults();
    }

    private void displayResults() {
        TextView buildingriskanalysis = findViewById(R.id.buildingriskanalysis);
        buildingriskanalysis.setText(computerResults() + " Units");
    }

    private double computerResults() {
        return 1.23;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
