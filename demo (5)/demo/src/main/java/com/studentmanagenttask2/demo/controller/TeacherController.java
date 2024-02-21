package com.studentmanagenttask2.demo.controller;

import com.studentmanagenttask2.demo.entity.Course;
import com.studentmanagenttask2.demo.entity.Quiz;
import com.studentmanagenttask2.demo.entity.Teacher;
import com.studentmanagenttask2.demo.services.teacher.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/teacher")

public class TeacherController {
    private TeacherService TS;
    @Autowired
    public TeacherController(TeacherService TS) {
        this.TS = TS;
    }

    @PostMapping("/addteacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher t ){
        TS.addTeacher(t);
        return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getteacher/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id){
        return new ResponseEntity<>(TS.getTeacher(id),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity <List<Teacher>> getAllTeachers(){
        return new ResponseEntity<>(TS.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteteacher/{id}")

    public ResponseEntity<String> deleteTeacher(@PathVariable int id){
        TS.deleteTeacher(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/updateteacher/{id}")
    public ResponseEntity<String> updateTeacher(@PathVariable int id,@RequestBody Teacher t){
        TS.updateTeacher(id,t);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }
}
