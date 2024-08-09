package com.taskmanagementsystem.tms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(nullable = false, unique = true)
    private String name ;
    @Column(nullable = false, unique = true)
    private String email ;
    private String phone ;
    @Column(nullable = false)
    private String password;
    private String profilePicture ;
    @Column(nullable = false)
    private Role role ;
    private int score ;
    @OneToMany(mappedBy = "profile" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> taskList = new ArrayList<>() ;
}
