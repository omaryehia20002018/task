package com.studentmanagenttask2.demo.services.student;

import com.studentmanagenttask2.demo.entity.Student;

import java.util.List;

public interface StudentService {

    public void addStudent(Student s);

    public void deleteStudent(int id);

    public Student getStudent(int id);

    public List<Student> getAll();

    public void updateStudent(int id, Student s);
}
