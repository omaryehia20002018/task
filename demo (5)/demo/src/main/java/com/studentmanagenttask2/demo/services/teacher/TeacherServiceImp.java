package com.studentmanagenttask2.demo.services.teacher;

import com.studentmanagenttask2.demo.entity.Teacher;
import com.studentmanagenttask2.demo.repositry.teacher.TeacherRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImp implements TeacherService {
    private TeacherRepositry TS;



    @Autowired
    public TeacherServiceImp(TeacherRepositry TS) {
        this.TS = TS;
    }



    @Override
    public void addTeacher(Teacher t) {
        TS.save(t);
    }

    @Override
    public void deleteTeacher(int id) {
         TS.deleteById(id);
    }

    @Override
    public Teacher getTeacher(int id) {
        return TS.findById(id).get();
    }

    @Override
    public List<Teacher> getAll() {
        return TS.findAll();
    }

    @Override
    public void updateTeacher(int id, Teacher t) {
       Teacher tt=TS.findById(id).get();
       if(t.getAge()!=null){
           tt.setAge(t.getAge());
       }

        if(t.getSalary()!=null){
            tt.setSalary(t.getSalary());
        }

        if(t.getFirstName()!=null){
            tt.setFirstName(t.getFirstName());
        }

        if(t.getLastName()!=null){
            tt.setLastName(t.getLastName());
        }

        if(t.getCode()!=null){
            tt.setCode(t.getCode());
        }

        TS.save(tt);
    }
}
