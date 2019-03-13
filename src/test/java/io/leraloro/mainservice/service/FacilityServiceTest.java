package io.leraloro.mainservice.service;

import io.leraloro.mainservice.model.Facility;
import io.leraloro.mainservice.repository.FacilityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FacilityServiceTest {

    @MockBean
    FacilityRepository facilityRepository;

    @Autowired
    FacilityService facilityService;

    public List<Facility> getFacilities() {
        List<Facility> facilities = new ArrayList<>();

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

        return facilities;
    }

    public Facility getFacility() {
        return Facility.builder()
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

//    public void mockData(){
//
//        Mockito.when(facilityRepository.findTop10ByOrderByCreatedOnDesc()).thenReturn(getFacilities());
//    }

    @Test
    public void testThatFacilityWasSaved() {
        Mockito.when(facilityRepository.save(getFacility())).thenReturn(getFacility());
        Facility facility = facilityService.saveFacility(getFacility());
        System.out.println(facility.toString());
//        System.out.println(facility.getName());
//        assertThat(facility.getName()).isEqualTo(getFacility().getName());
    }

//    @Test
//    public void testRecentFacilitiesExists(){
//        mockData();
//        List<Facility> recentFacilities = facilityService.recentFacilities();
//        assertThat(recentFacilities.size()).isEqualTo(getFacilities().size());
//    }
}