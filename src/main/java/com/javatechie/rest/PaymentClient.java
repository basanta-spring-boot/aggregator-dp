package com.javatechie.rest;

import com.javatechie.dto.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    private static final Logger logger = LoggerFactory.getLogger(PaymentClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(String paymentId) {
        try {
            logger.info("Fetching payment details for paymentId: {}", paymentId);
            Payment payment = restTemplate.getForObject("http://localhost:8083/payments/" + paymentId, Payment.class);
            logger.info("Successfully fetched payment details: {}", payment);
            return payment;
        } catch (Exception ex) {
            logger.error("Exception occurred while fetching payment details for paymentId: {}. Error: {}", paymentId, ex.getMessage(), ex);
            return null;
        }
    }
}
