package io.leraloro.mainservice.repository;

import io.leraloro.mainservice.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findTop10ByOrderByCreatedOnDesc();
}
