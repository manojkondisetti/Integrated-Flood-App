package com.example.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.model.UserData;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private EditText people, areaTop, areanOnTop, average;
    private int noOfPeople, areaOfRoofTop, areaOfNonRoofTop, averageWaterDemand;
    private RadioButton radioButton1, radioButton2;
    private RadioGroup radioGroup1, radioGroup2;
    private String roofType, bmptype;
    private UserData userData;
    private LatLng defaultLatLng = new LatLng(17.367439, 78.475853);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        FloatingActionButton next = findViewById(R.id.NextMain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                people = findViewById(R.id.NumberOfPeople);
                areaTop = findViewById(R.id.AreaOfRoof);
                areanOnTop = findViewById(R.id.NonRoofTopArea);
                average = findViewById(R.id.AverageWaterDemand);
                radioGroup1 = findViewById(R.id.RoofTypes);
                radioGroup2 = findViewById(R.id.BMPs);

                if (validateInput()) {
                    noOfPeople = Integer.parseInt(people.getText().toString());
                    areaOfRoofTop = Integer.parseInt(areaTop.getText().toString());
                    areaOfNonRoofTop = Integer.parseInt(areanOnTop.getText().toString());
                    averageWaterDemand = Integer.parseInt(average.getText().toString());
                    radioButton1 = findViewById(radioGroup1.getCheckedRadioButtonId());
                    roofType = radioButton1.getText().toString();
                    radioButton2 = findViewById(radioGroup2.getCheckedRadioButtonId());
                    bmptype = radioButton2.getText().toString();

                    userData = new UserData(noOfPeople, areaOfRoofTop, areaOfNonRoofTop,
                            averageWaterDemand, roofType, bmptype, defaultLatLng.latitude, defaultLatLng.longitude);

                    Toast.makeText(getApplicationContext(), "Data is saved for processing", Toast.LENGTH_SHORT).show();
                    openMapsActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Checks if all the fields are non-empty
     * @return
     */
    private boolean validateInput() {
        return people.length()!=0 && areaTop.length()!=0 && areanOnTop.length()!=0
                && average.length()!=0 && radioGroup1.getCheckedRadioButtonId() != -1
                && radioGroup2.getCheckedRadioButtonId() != -1;
    }

    private void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("UserData", userData);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}