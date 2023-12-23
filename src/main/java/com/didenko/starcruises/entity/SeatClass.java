package com.didenko.starcruises.entity;

public enum SeatClass {
    INTERIOR("Interior"), OUTSIDE_VIEW("Outside view"), BALCONY("Balcony"), SUITE("Suite");

    private final String name;

    SeatClass(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}