package io.leraloro.mainservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue facilityQueue() {
        return new Queue("facilities.queue");
    }

    @Bean("email.notification")
    public Queue emailNotificationQueue() {
        return new Queue("send.email.notification");
    }

}