package com.studentmanagenttask2.demo.services.course;

import com.studentmanagenttask2.demo.entity.Course;

import java.util.List;

public interface CourseService {
    public void addCourse(Course c);

    public void deleteCourse(int id);

    public Course getCourse(int id);


    public List<Course> getAll();

    public void updateCourse(int id, Course c);
}
