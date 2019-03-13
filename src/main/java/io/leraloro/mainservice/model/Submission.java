package io.leraloro.mainservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@EntityListeners(SubmissionListener.class)
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
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
