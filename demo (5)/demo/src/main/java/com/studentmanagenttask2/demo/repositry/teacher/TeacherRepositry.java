package com.studentmanagenttask2.demo.repositry.teacher;

import com.studentmanagenttask2.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositry extends JpaRepository<Teacher,Integer> {
}
