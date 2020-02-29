package com.marin.coronavirusapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoronavirusData {

    public static List<CoronavirusData> virusData = new ArrayList<>();

    private String state;
    private String country;
    private int numberOfCases;
    private int newCases;

}
