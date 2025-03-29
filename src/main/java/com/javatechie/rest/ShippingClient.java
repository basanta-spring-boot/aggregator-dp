package com.javatechie.rest;

import com.javatechie.dto.Shipping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShippingClient {

    private static final Logger logger = LoggerFactory.getLogger(ShippingClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public Shipping getShipment(String shipmentId) {
        try {
            logger.info("Fetching shipment details for shipmentId: {}", shipmentId);
            Shipping shipping = restTemplate.getForObject("http://localhost:8082/shipping/" + shipmentId, Shipping.class);
            logger.info("Successfully fetched shipment details: {}", shipping);
            return shipping;
        } catch (Exception ex) {
            logger.error("Exception occurred while fetching shipment details for orderId: {}. Error: {}", shipmentId, ex.getMessage(), ex);
            return null;
        }
    }
}
