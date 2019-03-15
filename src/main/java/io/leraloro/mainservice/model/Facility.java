package io.leraloro.mainservice.model;

import io.leraloro.mainservice.Listeners.FacilityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(FacilityListener.class)
@Table(name = "facility")
public class Facility implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    double longitude;

    double latitude;

    String wardCode;

    String services;

    String stateCode;

    String lgaCode;

    String name;

    String type;

    String state;

    String ward;

    String lga;

    String ownership;

    String functional;

    Date createdOn;


}
