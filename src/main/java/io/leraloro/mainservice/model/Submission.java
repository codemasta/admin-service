package io.leraloro.mainservice.model;

import io.leraloro.mainservice.Listeners.FacilityListener;
import io.leraloro.mainservice.Listeners.SubmissionListener;
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
@EntityListeners(SubmissionListener.class)
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    double longitude;

    double latitude;

    String email;

    String services;

    String state;

    String name;

    String type;

    String ward;

    String lga;

    String ownership;

    String functional;

    Date createdOn;

}
