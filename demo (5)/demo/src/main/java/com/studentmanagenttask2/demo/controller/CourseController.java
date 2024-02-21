package com.studentmanagenttask2.demo.controller;

import com.studentmanagenttask2.demo.entity.Course;
import com.studentmanagenttask2.demo.entity.Quiz;
import com.studentmanagenttask2.demo.entity.Teacher;
import com.studentmanagenttask2.demo.services.course.CourseService;
import com.studentmanagenttask2.demo.services.teacher.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
@RequestMapping("/api/course")

public class CourseController {
    private CourseService CS;

    @Autowired
    private TeacherService TS;

    public CourseController() {
    }

    @Autowired
    public CourseController(CourseService CS) {
        this.CS = CS;
    }





    @PostMapping("/addcourse")

    public ResponseEntity<String> addCourse(@RequestBody Course c ){
        CS.addCourse(c);
        return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getcourse/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        System.out.println("oj");
        return new ResponseEntity<>(CS.getCourse(id),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity <List<Course>> getAllCourses(){
        return new ResponseEntity<>(CS.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/deletecourse/{id}")

    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        CS.deleteCourse(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/updatecourse/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id,@RequestBody Course c){
        CS.updateCourse(id,c);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }
    @GetMapping("/savecourses")
    public String saveCourse(Model m){
        Course c=new Course();
        m.addAttribute("course",c);
        return "courseshowform";
    }
    @GetMapping("/s")
    public String SuccessCourse(@ModelAttribute("course") Course c, BindingResult theBindingResult){
        int id=c.getId();
        Optional<Teacher>tt= Optional.ofNullable(c.getTeacher());
        if(theBindingResult.hasErrors()&& tt.isEmpty()){
             System.out.println("lk");
            return "courseshowform";
        }

        else{
            //Teacher t=TS.getTeacher(id);
            c.setTeacher(tt.get());
            CS.addCourse(c);
            return "coursesuccessform";
        }
    }
    @GetMapping("/showcourses")
    public String showCourses(Model m){
        m.addAttribute("courses",CS.getAll());
        return "showcoursesform";
    }
}
