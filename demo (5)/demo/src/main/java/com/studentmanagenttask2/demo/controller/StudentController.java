package com.studentmanagenttask2.demo.controller;

import com.studentmanagenttask2.demo.entity.Course;
import com.studentmanagenttask2.demo.entity.Quiz;
import com.studentmanagenttask2.demo.entity.Student;
import com.studentmanagenttask2.demo.services.student.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/student")

public class StudentController {
    private StudentService SS;
    @Autowired
    public StudentController(StudentService SS) {
        this.SS = SS;
    }

    @PostMapping("/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody Student s ){
        SS.addStudent(s);
        return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        return new ResponseEntity<>(SS.getStudent(id),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity <List<Student>> getAllStudents(){
        return new ResponseEntity<>(SS.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/deletestudent/{id}")

    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        SS.deleteStudent(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id,@RequestBody Student s){
        SS.updateStudent(id,s);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }
}
