package com.example.myapp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BuildingRiskAnalysisUserData implements Serializable {
    @NonNull private Double floodDepthData;
    @NonNull private Double roofTopArea;
    @NonNull private Double perimeterOfBuilding;
    @NonNull private Double waterProofingDepth;
    @NonNull private Double degreeOfProtection;
}
