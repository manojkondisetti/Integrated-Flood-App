package com.example.myapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.maps.BMPData;
import com.example.myapp.R;
import com.example.myapp.maps.RoofType;
import com.example.myapp.model.BMPObject;
import com.example.myapp.model.UserData;

import java.util.Map;

import static com.example.myapp.constants.Constants.DAYS_IN_AN_YEAR;
import static com.example.myapp.constants.Constants.INFILTRATION_BASIN;
import static com.example.myapp.constants.Constants.INFILTRATION_TRENCH;
import static com.example.myapp.constants.Constants.RAIN_BARRELS;
import static com.example.myapp.maps.RainfallData.RAINFALL_AVERAGE_PER_YEAR;

public class FinalActivity extends AppCompatActivity {

    private double roofTopArea;
    private double waterDemand;
    private double waterSavedFromRoofTop;
    private double waterSavedFromNonRoofTop;
    private double cost;
    private Map<String, BMPObject> bmpMap;
    private Map<String, Double> roofMap;
    private BMPData bmpData = new BMPData();
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userData = (UserData) getIntent().getSerializableExtra("UserData");
        setContentView(R.layout.activity_final);
        resultsDisplay();
        usefulDataDisplay();
    }

    private void resultsDisplay() {
        bmpMap = bmpData.getBMPDataMap();
        roofMap = RoofType.getRoofMap();
        roofTopArea = userData.getAreaOfRoofTop();
        waterDemand = userData.getNoOfPeople() * userData.getAverageWaterDemand() * DAYS_IN_AN_YEAR;
        waterSavedFromNonRoofTop = RAINFALL_AVERAGE_PER_YEAR * userData.getAreaOfNonRoofTop()
                * bmpMap.get(userData.getBmpType()).getEfficiency();
        cost = userData.getAreaOfNonRoofTop() * bmpMap.get(userData.getBmpType()).getDepth() * 3500;

        if (roofTopArea < 50) {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(RAIN_BARRELS);
        } else if (roofTopArea >= 50 && roofTopArea < 200) {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(INFILTRATION_TRENCH);
        } else {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(INFILTRATION_BASIN);
        }

        TextView value11 = findViewById(R.id.value11);
        value11.setText(waterDemand + "L");

        TextView value12 = findViewById(R.id.value12);
        value12.setText(waterSavedFromRoofTop + "L");

        TextView value13 = findViewById(R.id.value13);
        value13.setText(String.valueOf(waterSavedFromNonRoofTop));

        TextView value14 = findViewById(R.id.value14);
        value14.setText(cost + "/-");

    }

    private void usefulDataDisplay() {
        TextView rainfall = findViewById(R.id.value21);
        rainfall.setText(RAINFALL_AVERAGE_PER_YEAR + "m");

        TextView value22 = findViewById(R.id.value22);
        value22.setText("RooftopArea>=200sq.m \n"
                + "(efficiency" + bmpMap.get(INFILTRATION_BASIN).getEfficiency() + ")");

        TextView value23 = findViewById(R.id.value23);
        value23.setText("RooftopArea>=50sq.m and <200 \n"
                + "(efficiency" + bmpMap.get(INFILTRATION_TRENCH).getEfficiency() + ")");

        TextView value24 = findViewById(R.id.value24);
        value24.setText("RooftopArea<50sq.m \n"
                + "(efficiency" + bmpMap.get(RAIN_BARRELS).getEfficiency() + ")");

    }

    private double getWaterSavedFromRainFall(String BMP) {
        return RAINFALL_AVERAGE_PER_YEAR * userData.getAreaOfRoofTop()
                * bmpMap.get(BMP).getEfficiency()
                * roofMap.get(userData.getRoofType());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}