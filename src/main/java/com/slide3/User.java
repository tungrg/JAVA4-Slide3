package com.slide3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data   
public class User {
    @Id
    private String id;
    private String fullname;
    private String password;
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    private Boolean admin;


    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    // Additional fields and methods can be added as needed
}
