package com.marin.coronavirusapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoronavirusData {

    private String State;
    private String Country;
    private int newCases;

}
