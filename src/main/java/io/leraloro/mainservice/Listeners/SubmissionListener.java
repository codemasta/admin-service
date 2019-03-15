package io.leraloro.mainservice.Listeners;

import io.leraloro.mainservice.model.EmailMessage;
import io.leraloro.mainservice.model.Submission;
import io.leraloro.mainservice.util.QueueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Component
public class SubmissionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static RabbitTemplate rabbitTemplate;

    private static Queue submissionNotification;

    /**
     * manually injection of the required beans because does its instantiation before spring */

    @Autowired
    public void init(RabbitTemplate rabbitTemplate,  @Qualifier("email.notification") Queue submissionNotification) {
        SubmissionListener.submissionNotification = submissionNotification;
        SubmissionListener.rabbitTemplate = rabbitTemplate;

    }

    /**
     * sends a facility created message to the queue for the search index
     * works as a post persist listener to the storage directly.
     * Mapped out Email Notification object.*/
    @PostPersist
    public void sendMessage(Submission submission) {
        QueueUtils submissionMessage = new QueueUtils<EmailMessage>();
        rabbitTemplate.convertAndSend(
                submissionNotification.getName(), submissionMessage.serializeToJson(EmailMessage.builder()
                        .message("You recently submitted a facility with the name "+ submission.getName()+" to the LeraLoro platform. \n The facility is presently under review" +
                                "and you will notify whenever there is any update on it.")
                        .receiver(submission.getEmail())
                        .subject("Facility Submission")
                        .build(), logger));
    }
}
