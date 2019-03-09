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

    @Autowired
    public void init(RabbitTemplate rabbitTemplate, Queue facilityQueue) {
        FacilityListener.facilityQueue = facilityQueue;
        FacilityListener.rabbitTemplate = rabbitTemplate;

    }

    @PostPersist
    public void sendMessage(Facility facility) {
        QueueUtils facilitySerialize = new QueueUtils<Facility>();
        rabbitTemplate.convertAndSend(
                facilityQueue.getName(), facilitySerialize.serializeToJson(facility, logger));
    }
}
