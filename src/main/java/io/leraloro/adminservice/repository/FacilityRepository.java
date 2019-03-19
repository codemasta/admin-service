package io.leraloro.adminservice.repository;

import io.leraloro.adminservice.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findTop10ByOrderByCreatedOnDesc();
}
