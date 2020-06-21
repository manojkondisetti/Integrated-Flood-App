package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

import static com.example.myapp.Constants.DAYS_IN_AN_YEAR;
import static com.example.myapp.Constants.INFILTRATION_BASIN;
import static com.example.myapp.Constants.INFILTRATION_TRENCH;
import static com.example.myapp.Constants.RAIN_BARRELS;
import static com.example.myapp.RainfallData.RAINFALL_AVERAGE_PER_YEAR;

public class FinalActivity extends AppCompatActivity {

    double roofTopArea;
    double waterDemand;
    double waterSavedFromRoofTop;
    double waterSavedFromNonRoofTop;
    double cost;
    Map<String, BMPObject> bmpMap;
    Map<String, Double> roofMap;
    BMPData bmpData = new BMPData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        resultsDisplay();
        usefulDataDisplay();
    }

    private void resultsDisplay() {
        bmpMap = bmpData.getBMPDataMap();
        roofMap = RoofType.getRoofMap();
        roofTopArea = UserData.getAreaOfRoofTop();
        waterDemand = UserData.getNoOfPeople() * UserData.getAverageWaterDemand() * DAYS_IN_AN_YEAR;
        waterSavedFromNonRoofTop = RAINFALL_AVERAGE_PER_YEAR * UserData.getAreaOfNonRoofTop()
                * bmpMap.get(UserData.getBmpType()).getEfficiency();
        cost = UserData.getAreaOfNonRoofTop() * bmpMap.get(UserData.getBmpType()).getDepth() * 3500;

        if (roofTopArea < 50) {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(RAIN_BARRELS);
        } else if (roofTopArea >= 50 && roofTopArea < 200) {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(INFILTRATION_TRENCH);
        } else {
            waterSavedFromRoofTop = getWaterSavedFromRainFall(INFILTRATION_BASIN);
        }

        TextView value11 = (TextView) findViewById(R.id.value11);
        value11.setText(String.valueOf(waterDemand) + "L");

        TextView value12 = (TextView) findViewById(R.id.value12);
        value12.setText(String.valueOf(waterSavedFromRoofTop) + "L");

        TextView value13 = (TextView) findViewById(R.id.value13);
        value13.setText(String.valueOf(waterSavedFromNonRoofTop));

        TextView value14 = (TextView) findViewById(R.id.value14);
        value14.setText(String.valueOf(cost) + "/-");

    }

    private void usefulDataDisplay() {
        TextView rainfall = (TextView) findViewById(R.id.value21);
        rainfall.setText(String.valueOf(RAINFALL_AVERAGE_PER_YEAR) + "m");

        TextView value22 = (TextView) findViewById(R.id.value22);
        value22.setText("RooftopArea>=200sq.m \n"
                + "(efficiency" + String.valueOf(bmpMap.get(INFILTRATION_BASIN).getEfficiency()) + ")");

        TextView value23 = (TextView) findViewById(R.id.value23);
        value23.setText("RooftopArea>=50sq.m and <200 \n"
                + "(efficiency" + String.valueOf(bmpMap.get(INFILTRATION_TRENCH).getEfficiency()) + ")");

        TextView value24 = (TextView) findViewById(R.id.value24);
        value24.setText("RooftopArea<50sq.m \n"
                + "(efficiency" + String.valueOf(bmpMap.get(RAIN_BARRELS).getEfficiency()) + ")");

    }

    private double getWaterSavedFromRainFall(String BMP) {
        return RAINFALL_AVERAGE_PER_YEAR * UserData.getAreaOfRoofTop()
                * bmpMap.get(BMP).getEfficiency()
                * roofMap.get(UserData.getRoofType());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}