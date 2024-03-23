package com.didenko.starcruises.configuration;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayPalConfiguration {

    @Bean
    public PayPalHttpClient getPayPalClient(
        @Value("${paypal.clientId}") String clientId,
        @Value("${paypal.clientSecret}") String clientSecret){
        return new PayPalHttpClient(new PayPalEnvironment.Sandbox(clientId, clientSecret));
    }
}
