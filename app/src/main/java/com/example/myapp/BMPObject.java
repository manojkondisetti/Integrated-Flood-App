package com.example.myapp;

public class BMPObject {
    private String bmpName;
    private double depth;
    private double efficiency;

    public BMPObject(String bmpName, double depth, double efficiency) {
        this.bmpName = bmpName;
        this.depth = depth;
        this.efficiency = efficiency;
    }

    public String getBmpName() {
        return bmpName;
    }

    public double getDepth() {
        return depth;
    }

    public double getEfficiency() {
        return efficiency;
    }
}
