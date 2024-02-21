package com.studentmanagenttask2.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
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

    @Column(name = "salary")
    private Integer salary;


}
