package com.example.myapp.activity.buildingriskanalysis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.model.BuildingRiskAnalysisUserData;
import com.example.myapp.model.FloodIndentationUserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuildingRiskAnalysisMainActivity extends AppCompatActivity {
    private EditText A1, A2, A3, A4, A5;
    private Double floodDepthData, roofTopArea, perimeterOfBuilding, waterProofingDepth, degreeOfProtection;

    private BuildingRiskAnalysisUserData buildingRiskAnalysisUserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildingriskanalysis);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        FloatingActionButton next = findViewById(R.id.NextMain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A1 = findViewById(R.id.A1);
                A2 = findViewById(R.id.A2);
                A3 = findViewById(R.id.A3);
                A4 = findViewById(R.id.A4);
                A5 = findViewById(R.id.A5);

                if(validateInput()) {
                    floodDepthData = Double.parseDouble(A1.getText().toString());
                    roofTopArea = Double.parseDouble(A2.getText().toString());
                    perimeterOfBuilding = Double.parseDouble(A3.getText().toString());
                    waterProofingDepth = Double.parseDouble(A4.getText().toString());
                    degreeOfProtection = Double.parseDouble(A5.getText().toString());

                    buildingRiskAnalysisUserData = new BuildingRiskAnalysisUserData(floodDepthData, roofTopArea,
                            perimeterOfBuilding, waterProofingDepth, degreeOfProtection);
                    floodIndentationFinalActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private boolean validateInput() {
        return A1.length()!=0 && A2.length()!=0 && A3.length()!=0 && A4.length()!=0 && A5.length()!=0;
    }

    private void floodIndentationFinalActivity() {
        Intent intent = new Intent(this, BuildingRiskAnalysisFinalActivity.class);
        intent.putExtra("buildingRiskAnalysisUserData", buildingRiskAnalysisUserData);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
