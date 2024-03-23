package com.didenko.starcruises.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentOrder {

    private final String status;

    private String orderId;

    private String redirectUrl;

}
