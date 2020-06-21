package com.example.myapp;

import com.google.android.gms.maps.model.LatLng;

public class UserData {
    private static int noOfPeople;
    private static double areaOfRoofTop;
    ;
    private static double areaOfNonRoofTop;
    private static double averageWaterDemand;
    private static String roofType;
    private static String bmpType;
    private static LatLng location;

    public static int getNoOfPeople() {
        return noOfPeople;
    }

    public static void setNoOfPeople(int noOfPeople) {
        UserData.noOfPeople = noOfPeople;
    }

    public static double getAreaOfRoofTop() {
        return areaOfRoofTop;
    }

    public static void setAreaOfRoofTop(double areaOfRoofTop) {
        UserData.areaOfRoofTop = areaOfRoofTop;
    }

    public static double getAreaOfNonRoofTop() {
        return areaOfNonRoofTop;
    }

    public static void setAreaOfNonRoofTop(double areaOfNonRoofTop) {
        UserData.areaOfNonRoofTop = areaOfNonRoofTop;
    }

    public static double getAverageWaterDemand() {
        return averageWaterDemand;
    }

    public static void setAverageWaterDemand(double averageWaterDemand) {
        UserData.averageWaterDemand = averageWaterDemand;
    }

    public static String getRoofType() {
        return roofType;
    }

    public static void setRoofType(String roofType) {
        UserData.roofType = roofType;
    }

    public static String getBmpType() {
        return bmpType;
    }

    public static void setBmpType(String bmpType) {
        UserData.bmpType = bmpType;
    }

    public static LatLng getLocation() {
        return location;
    }

    public static void setLocation(LatLng location) {
        UserData.location = location;
    }
}
