package com.didenko.starcruises.entity;

import lombok.Getter;

@Getter
public enum CrusieState {

    UPCOMING("Upcoming", 2),
    CANCELED("Canceled", 4),
    STARTED("Started", 1),
    COMPLETED("Completed", 3);

    private final String stateValue;

    private final Integer priority;

    CrusieState (String cruiseState, Integer priority){
        stateValue = cruiseState;
        this.priority = priority;
    }
}
