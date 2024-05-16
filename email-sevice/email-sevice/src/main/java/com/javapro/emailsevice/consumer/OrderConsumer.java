package com.javapro.emailsevice.consumer;

import com.javapro.emailsevice.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent event) {
        log.info(String.format("Order event received -> %s", event.toString()));
        //logic to send email
    }
}
