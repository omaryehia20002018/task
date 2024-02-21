package com.studentmanagenttask2.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String FirstName;

    @Column(name = "lastname")
    private String LastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "code")
    private String code;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="studentcourse",joinColumns = @JoinColumn(name="studentid"),inverseJoinColumns = @JoinColumn(name = "courseid"))
    private List<Course> courses;
}
