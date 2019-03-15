package io.leraloro.mainservice.Listeners;

import io.leraloro.mainservice.model.Facility;
import io.leraloro.mainservice.util.QueueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Component
public class FacilityListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static RabbitTemplate rabbitTemplate;

    private static Queue facilityQueue;

    /**
     * manually injection of the required beans because does its instantiation before spring */
    @Autowired
    public void init(RabbitTemplate rabbitTemplate, Queue facilityQueue) {
        FacilityListener.facilityQueue = facilityQueue;
        FacilityListener.rabbitTemplate = rabbitTemplate;

    }

    /**
     * sends a facility created message to the queue for the search index
     * works as a post persist listener to the storage directly */
    @PostPersist
    public void sendMessage(Facility facility) {
        QueueUtils payloadSerialize = new QueueUtils<Facility>();
        rabbitTemplate.convertAndSend(
                facilityQueue.getName(), payloadSerialize.serializeToJson(facility, logger));
    }
}
