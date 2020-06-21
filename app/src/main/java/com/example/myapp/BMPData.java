package com.example.myapp;


import java.util.HashMap;
import java.util.Map;

import static com.example.myapp.Constants.BIORETENTION;
import static com.example.myapp.Constants.CONSTRUCTED_WETLANDS;
import static com.example.myapp.Constants.GRASSED_SWALES;
import static com.example.myapp.Constants.INFILTRATION_BASIN;
import static com.example.myapp.Constants.INFILTRATION_TRENCH;
import static com.example.myapp.Constants.POROUS_PAVEMENT;
import static com.example.myapp.Constants.RAIN_BARRELS;
import static com.example.myapp.Constants.SAND_FILTER_SURFACE;
import static com.example.myapp.Constants.VEGETATED_FILTER_STRIPS;

public class BMPData {

    public Map<String, BMPObject> getBMPDataMap() {
        Map<String, BMPObject> bmpDataList = new HashMap<String, BMPObject>();

        BMPObject infiltrationBasin = new BMPObject(INFILTRATION_BASIN, 3, 0.75);
        BMPObject infiltrationTrench = new BMPObject(INFILTRATION_TRENCH, 3, 0.75);
        BMPObject rainBarrel = new BMPObject(RAIN_BARRELS, 2, 0.8);
        BMPObject vegetatedFilterStrips = new BMPObject(VEGETATED_FILTER_STRIPS, 0.5, 0.57);
        BMPObject porousPavement = new BMPObject(POROUS_PAVEMENT, 0.6, 0.75);
        BMPObject grassedSwales = new BMPObject(GRASSED_SWALES, 0.45, 0.6);
        BMPObject constructedWetland = new BMPObject(CONSTRUCTED_WETLANDS, 1, 0.1);
        BMPObject bioretention = new BMPObject(BIORETENTION, 0.5, 0.8);
        BMPObject sandFilterSurface = new BMPObject(SAND_FILTER_SURFACE, 1, 0.5);

        bmpDataList.put(INFILTRATION_BASIN, infiltrationBasin);
        bmpDataList.put(INFILTRATION_TRENCH, infiltrationTrench);
        bmpDataList.put(RAIN_BARRELS, rainBarrel);
        bmpDataList.put(VEGETATED_FILTER_STRIPS, vegetatedFilterStrips);
        bmpDataList.put(POROUS_PAVEMENT, porousPavement);
        bmpDataList.put(GRASSED_SWALES, grassedSwales);
        bmpDataList.put(CONSTRUCTED_WETLANDS, constructedWetland);
        bmpDataList.put(BIORETENTION, bioretention);
        bmpDataList.put(SAND_FILTER_SURFACE, sandFilterSurface);

        return bmpDataList;
    }
}
