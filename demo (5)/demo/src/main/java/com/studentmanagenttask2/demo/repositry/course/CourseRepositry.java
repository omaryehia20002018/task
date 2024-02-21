package com.studentmanagenttask2.demo.repositry.course;

import com.studentmanagenttask2.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositry extends JpaRepository<Course,Integer> {
}
