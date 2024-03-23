package com.didenko.starcruises.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CompletedOrder {

    private final String status;

    private String token;
}
