package com.javapro.ordersevice.controller;

import com.javapro.ordersevice.dto.Order;
import com.javapro.ordersevice.dto.OrderEvent;
import com.javapro.ordersevice.publisher.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order is in pending status");
        event.setOrder(order);
        orderProducer.sendMessage(event);
        return "Order sent to RabbitMQ...";
    }
}
