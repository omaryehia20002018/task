package com.studentmanagenttask2.demo.repositry.student;

import com.studentmanagenttask2.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends JpaRepository<Student,Integer> {
}
