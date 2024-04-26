package com.didenko.starcruises.entity;

import lombok.Getter;

@Getter
public enum PageSizeOption {

    THREE(3), FIVE(5), TEN(10);

    private final Integer size;

    PageSizeOption(Integer size){
        this.size = size;
    }
}
