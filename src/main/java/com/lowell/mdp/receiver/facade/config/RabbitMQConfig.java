package com.lowell.mdp.receiver.facade.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HP on 2017/7/7.
 */
@Configuration
public class RabbitMQConfig {


    public static final String QUEUE_NAME = "spring-boot-simple";
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

}
