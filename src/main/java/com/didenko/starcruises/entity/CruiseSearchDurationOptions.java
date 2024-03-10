package com.didenko.starcruises.entity;

import java.util.function.Predicate;

public enum CruiseSearchDurationOptions {

    ANY("Any", integer -> true),
    SHORTEST("2-5", integer -> integer >= 2 && integer <= 5),
    SHORT("5-7", integer -> integer >= 5 && integer <= 7),
    MEDIUM("7-10", integer -> integer >= 7 && integer <= 10),
    LONGEST("10+", integer -> integer >= 10);

    public final String nights;
    public final Predicate<Integer> predicate;

    CruiseSearchDurationOptions (String nights, Predicate<Integer> predicate){
        this.nights = nights;
        this.predicate = predicate;
    }

}
