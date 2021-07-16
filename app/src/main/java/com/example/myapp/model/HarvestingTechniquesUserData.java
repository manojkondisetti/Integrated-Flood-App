package com.example.myapp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HarvestingTechniquesUserData implements Serializable {
    @NonNull private int noOfPeople;
    @NonNull private double areaOfRoofTop;
    @NonNull private double areaOfNonRoofTop;
    @NonNull private double averageWaterDemand;
    @NonNull private String roofType;
    @NonNull private String bmpType;
    @NonNull private double latitude;
    @NonNull private double longitude;
}
