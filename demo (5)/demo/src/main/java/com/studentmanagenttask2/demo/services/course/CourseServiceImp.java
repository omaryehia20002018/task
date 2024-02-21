package com.studentmanagenttask2.demo.services.course;

import com.studentmanagenttask2.demo.entity.Course;
import com.studentmanagenttask2.demo.repositry.course.CourseRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CourseServiceImp implements CourseService{

    private CourseRepositry CS;
    @Autowired
    public CourseServiceImp(CourseRepositry CS) {
        this.CS = CS;
    }




    @Override
    public void addCourse(Course c) {
        CS.save(c);
    }

    @Override
    public void deleteCourse(int id) {
        CS.deleteById(id);
    }

    @Override
    public Course getCourse(int id) {
        return CS.findById(id).get();
    }

    @Override
    public List<Course> getAll() {

        System.out.println("j");
        return CS.findAll();
    }

    @Override
    public void updateCourse(int id, Course c) {
         Course cc=CS.findById(id).get();
         if(c.getTitle()!=null){
             cc.setTitle(c.getTitle());
         }
         CS.save(cc);
    }
}
