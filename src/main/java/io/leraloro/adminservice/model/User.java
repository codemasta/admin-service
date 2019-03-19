package io.leraloro.adminservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide valid and unique username")
    private String username;

    @Column(name = "password")
    @Length(min = 6, message = "*Your password must have least 6 characters")
    private String password;

    @Column(name = "firstname")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "activated")
    private boolean activated;

    @Column(name = "role_id")
    private int role;

    private Date createdOn;

    private Date updatedOn;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}