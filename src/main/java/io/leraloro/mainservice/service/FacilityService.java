package io.leraloro.mainservice.service;

import io.leraloro.mainservice.model.Facility;
import io.leraloro.mainservice.repository.FacilityRepository;
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
        return facilityRepository.save(facility);
    }

    public List<Facility> recentFacilities() {
        return facilityRepository.findTop10ByOrderByCreatedOnDesc();
    }

}
