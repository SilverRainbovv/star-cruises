package com.didenko.starcruises.entity;

import lombok.Getter;

@Getter
public enum CrusieState {

    UPCOMING("Upcoming"),
    CANCELED("Canceled"),
    STARTED("Started"),
    COMPLETED("Completed");

    private final String stateValue;

    CrusieState (String cruiseState){
        stateValue = cruiseState;
    }
}
