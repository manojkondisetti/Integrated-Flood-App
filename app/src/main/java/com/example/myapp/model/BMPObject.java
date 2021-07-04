package com.example.myapp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

@AllArgsConstructor
@Setter
@Getter
public class BMPObject implements Serializable {
    @NonNull private final String bmpName;
    @NonNull private final double depth;
    @NonNull private final double efficiency;
}
