package com.javatechie.rest;

import com.javatechie.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    private static final Logger logger = LoggerFactory.getLogger(OrderClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public Order getOrder(String orderId) {
        try {
            logger.info("Fetching order details for orderId: {}", orderId);
            Order order = restTemplate.getForObject("http://localhost:8081/orders/" + orderId, Order.class);
            logger.info("Successfully fetched order details: {}", order);
            return order;
        } catch (Exception ex) {
            logger.error("Exception occurred while fetching order details for orderId: {}. Error: {}", orderId, ex.getMessage(), ex);
            return null;
        }
    }
}
