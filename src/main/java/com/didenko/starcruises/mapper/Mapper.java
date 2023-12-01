package com.didenko.starcruises.mapper;

public interface Mapper <F, T> {

    T mapFrom(F object);

}
