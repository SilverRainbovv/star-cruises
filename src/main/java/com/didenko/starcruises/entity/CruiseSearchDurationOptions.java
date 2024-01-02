package com.didenko.starcruises.entity;

public enum CruiseSearchDurationOptions {

    ANY("Any"), SHORTEST("2-5"), SHORT("5-7"), MEDIUM("7-10"), LONGEST("10+");

    public final String nights;

    CruiseSearchDurationOptions (String nights){
        this.nights = nights;
    }

}
