package com.sebastian.spring_boot_essential_tr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.UUID;
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dbId")
    private UUID id;
    @Column(name = "dbAge")
    private  Integer age;
    @Column(name = "dbFirstName")
    private  String firstName;
    @Column(name = "dbLastName")
    private  String lastName;
    @Column(name = "dbCourse")
    private  String course;


    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("age") Integer age,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("course") String course) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }
}
