package io.leraloro.adminservice.repository;

import io.leraloro.adminservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
