package io.leraloro.adminservice.service;

import io.leraloro.adminservice.model.Facility;
import io.leraloro.adminservice.repository.FacilityRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class FacilityServiceTest {

    static FacilityRepository facilityRepositoryMock;

    static FacilityService facilityService;

    List<Facility> facilities;

    Facility facility;

    @BeforeAll
    public static void setUp() {
        facilityRepositoryMock = Mockito.mock(FacilityRepository.class);
        facilityService = new FacilityService(facilityRepositoryMock);
    }


    @BeforeEach
    public void init() {
        facilities = new ArrayList<>();
        facilities.add(Facility.builder()
                .createdOn(new Date())
                .functional("Functional")
                .name("ABC Clinics")
                .latitude(54.44444)
                .longitude(24.112344)
                .ownership("PRIVATE")
                .state("OYO")
                .stateCode("023")
                .type("PRIMARY")
                .lga("Lagelu")
                .lgaCode("33")
                .services("Ante-Natal, Orthopadic")
                .build());

        facility = Facility.builder()
                .createdOn(new Date())
                .functional("Functional")
                .name("DEF Hospital")
                .latitude(33.44444)
                .longitude(21.1144)
                .ownership("PRIVATE")
                .state("OGUN")
                .stateCode("022")
                .type("PUBLIC")
                .lga("IJEBU-NORTH")
                .lgaCode("22")
                .services("Ante-Natal,Dentistry  Orthopadic")
                .build();
    }


    @Test
    public void testThatFacilityWasSaved() {
        when(facilityRepositoryMock.save(Mockito.any(Facility.class))).thenReturn(facility);
        facilityService.saveFacility(facility);
        Mockito.verify(facilityRepositoryMock, Mockito.times(1)).save(Mockito.any(Facility.class));
        assertThat(facility.getName()).isEqualTo(facility.getName());
    }

    @Test
    public void testRecentFacilitiesExists(){
        when(facilityRepositoryMock.findTop10ByOrderByCreatedOnDesc()).thenReturn(facilities);
        List<Facility> recentFacilities = facilityService.recentFacilities();
        assertThat(recentFacilities.size()).isEqualTo(facilities.size());
    }
}