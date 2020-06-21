package com.example.myapp;

import java.util.HashMap;
import java.util.Map;

import static com.example.myapp.Constants.FLAT_ROOF;
import static com.example.myapp.Constants.IRON_SHEETS;
import static com.example.myapp.Constants.THATCHED;
import static com.example.myapp.Constants.TILES;

public class RoofType {

    public static Map<String, Double> getRoofMap() {
        Map<String, Double> roofMap = new HashMap<String, Double>();

        roofMap.put(FLAT_ROOF, 1.0);
        roofMap.put(TILES, 1.0);
        roofMap.put(IRON_SHEETS, 1.0);
        roofMap.put(THATCHED, 1.0);

        return roofMap;
    }

}
