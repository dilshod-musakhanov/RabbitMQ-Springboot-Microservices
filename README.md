
### RabbitMQ Spring Boot Event Driven Microservices Architecture with Multiple Queues

This project implements a simple microservices-based order system using Spring Boot and RabbitMQ. The system consists of three main services: Order Service, Email Service, and Payment Service. 
The Order Service is responsible for handling order events and sending them via RabbitMQ to separate queues, from which the Email Service and Payment Service consume these events.

Technologies: Spring Boot, RabbitMQ, Spring AMQP

![Presentation2](https://github.com/dilshod-musakhanov/RabbitMQ-Springboot-Microservices/assets/95948718/78941244-00cc-41f4-b49d-4d54c2ca6085)
