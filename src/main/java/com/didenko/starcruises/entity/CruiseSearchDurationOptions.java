package com.didenko.starcruises.entity;

public enum CruiseSearchDurationOptions {

    ANY("Any", 1, Integer.MAX_VALUE),
    SHORTEST("2-5", 2, 5),
    SHORT("5-7", 5, 7),
    MEDIUM("7-10", 7, 10),
    LONGEST("10+", 10, Integer.MAX_VALUE);

    public final String nights;
    public final Integer minNights;
    public final Integer maxNights;
//    public final Predicate<Integer> predicate;


    CruiseSearchDurationOptions (String nights, Integer minNights, Integer maxNights){
        this.nights = nights;
        this.minNights = minNights;
        this.maxNights = maxNights;
    }



//    CruiseSearchDurationOptions (String nights, Predicate<Integer> predicate){
//        this.nights = nights;
//        this.predicate = predicate;
//    }

}
