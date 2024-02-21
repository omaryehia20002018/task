package com.studentmanagenttask2.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="creationdate")
    //@DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss.sss")
    private LocalDateTime CreationDate;

    @Column(name="startdatetime")
    //@DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss.sss")
    private LocalDateTime CreationDateTime;

    @Column(name="enddatetime")
    //@DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss.sss")
    private LocalDateTime EndDateTime;
    @Column(name = "name")
    private String name;

}
