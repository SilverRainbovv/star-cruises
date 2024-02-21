package com.didenko.starcruises.entity;

import lombok.Getter;

public enum ClientDocumentState {

    PENDING(1), APPROVED(2), REJECTED(3);

    @Getter
    private final Integer order;

    ClientDocumentState(Integer order){
        this.order = order;
    }
}