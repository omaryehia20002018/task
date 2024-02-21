package com.studentmanagenttask2.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "course")
public class Course {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    @JsonIgnore
    private Teacher teacher;

}
