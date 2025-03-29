package com.javatechie.controller;

import com.javatechie.dto.Order;
import com.javatechie.dto.OrderDetails;
import com.javatechie.dto.Payment;
import com.javatechie.dto.Shipping;
import com.javatechie.rest.OrderClient;
import com.javatechie.rest.PaymentClient;
import com.javatechie.rest.ShippingClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-aggregator")
public class OrderAggregatorController {


    private final OrderClient orderClient;

    private final ShippingClient shippingClient;

    private final PaymentClient paymentClient;

    public OrderAggregatorController(OrderClient orderClient, ShippingClient shippingClient, PaymentClient paymentClient) {
        this.orderClient = orderClient;
        this.shippingClient = shippingClient;
        this.paymentClient = paymentClient;
    }

    @GetMapping("/{orderId}")
    public OrderDetails getOrderDetails(@PathVariable String orderId) {

        Order order = orderClient.getOrder(orderId);
        Shipping shipping = shippingClient.getShipment(orderId);
        Payment payment = paymentClient.getPayment(orderId);

        return new OrderDetails(order, shipping, payment);
    }
}
