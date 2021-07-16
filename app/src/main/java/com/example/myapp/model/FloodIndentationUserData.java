package com.example.myapp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FloodIndentationUserData implements Serializable {
    @NonNull private Double rainfall;
    @NonNull private Double elevation;
    @NonNull private Double slope;
    @NonNull private Double distanceFromStream;
    @NonNull private Double evapotranspiration;
    @NonNull private Double surfaceTemperature;
    @NonNull private Double vegetationIndex;
    @NonNull private Double curveNumber;
}
