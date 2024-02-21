package com.studentmanagenttask2.demo.services.student;

import com.studentmanagenttask2.demo.entity.Student;
import com.studentmanagenttask2.demo.repositry.student.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class  StudentServiceImp implements StudentService {
    private StudentRepositry SS;

    @Autowired
    public StudentServiceImp(StudentRepositry SS) {
        this.SS = SS;
    }

    @Override
    public void addStudent(Student s) {
        SS.save(s);
    }

    @Override
    public void deleteStudent(int id) {
       SS.deleteById(id);
    }

    @Override
    public Student getStudent(int id) {
        return SS.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return SS.findAll();
    }

    @Override
    public void updateStudent(int id, Student s) {
       Student student=SS.findById(id).get();

       if(s.getAge()!=null){
           student.setAge(s.getAge());
       }
       if(s.getFirstName()!=null){
           student.setFirstName(s.getFirstName());
        }

        if(s.getLastName()!=null){
            student.setLastName(s.getLastName());
        }

        if(s.getCode()!=null){
             student.setCode(s.getCode());
        }

        SS.save(student);


    }
}
