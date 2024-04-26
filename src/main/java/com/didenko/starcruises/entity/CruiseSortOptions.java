package com.didenko.starcruises.entity;


public enum CruiseSortOptions {

    DEPARTURE_EARLIEST("Departure earliest"),
    DEPARTURE_LATEST("Departure latest"),
//    PRICE_ASCENDING("Price ascending"),
//    PRICE_DESCENDING("Price descending"),
    DURATION_ASCENDING("Duration ascending"),
    DURATION_DESCENDING("Duration descending");

    public final String option;

    CruiseSortOptions(String option){
        this.option = option;
    }


}
