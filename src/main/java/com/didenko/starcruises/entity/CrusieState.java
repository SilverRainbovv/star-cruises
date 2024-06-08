package com.didenko.starcruises.entity;

import lombok.Getter;

@Getter
public enum CrusieState {

    STARTED("Started", 1),
    UPCOMING("Upcoming", 2),
    COMPLETED("Completed", 3),
    CANCELED("Canceled", 4);

    private final String stateValue;

    private final Integer priority;

    CrusieState (String cruiseState, Integer priority){
        stateValue = cruiseState;
        this.priority = priority;
    }
}
