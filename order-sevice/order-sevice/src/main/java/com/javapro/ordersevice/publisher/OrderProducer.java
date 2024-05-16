package com.javapro.ordersevice.publisher;

import com.javapro.ordersevice.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j
public class OrderProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.order.routing.key}")
    private String orderRoutingKey;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent) {
        log.info(String.format("Order sent to RabbitMQ -> %s", orderEvent.toString()));
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, orderEvent);

        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);
    }
}
