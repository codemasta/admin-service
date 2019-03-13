package io.leraloro.mainservice.repository;

import io.leraloro.mainservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
