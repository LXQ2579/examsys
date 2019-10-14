package com.damo.examsys.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue stockQueue(){
        return new Queue("queue.stock123");
    }
}
