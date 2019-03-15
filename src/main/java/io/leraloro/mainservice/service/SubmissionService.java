package io.leraloro.mainservice.service;

import io.leraloro.mainservice.model.Submission;
import io.leraloro.mainservice.repository.SubmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SubmissionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public Submission saveSubmission(Submission submission) {
        submission.setCreatedOn(new Date());
        logger.info("Saving db object: {}", submission);
        return submissionRepository.save(submission);
    }
}
