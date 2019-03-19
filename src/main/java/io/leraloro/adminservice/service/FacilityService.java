package io.leraloro.adminservice.service;

import io.leraloro.adminservice.model.Facility;
import io.leraloro.adminservice.repository.FacilityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacilityService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private FacilityRepository facilityRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public Facility saveFacility(Facility facility) {
        facility.setCreatedOn(new Date());
        logger.info("Saving db object: {}", facility);
        return facilityRepository.save(facility);
    }

    public List<Facility> recentFacilities() {
        return facilityRepository.findTop10ByOrderByCreatedOnDesc();
    }

    public List<Facility> getIndexedFacilities() {
        return facilityRepository.findAll();
    }

}
