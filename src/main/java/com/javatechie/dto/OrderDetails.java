package com.javatechie.dto;

public class OrderDetails {

    private Order order;

    private Shipping shipping;

    private Payment payment;

    public OrderDetails() {
    }

    public OrderDetails(Order order, Shipping shipping, Payment payment) {
        this.order = order;
        this.shipping = shipping;
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "order=" + order +
                ", shipping=" + shipping +
                ", payment=" + payment +
                '}';
    }
}
