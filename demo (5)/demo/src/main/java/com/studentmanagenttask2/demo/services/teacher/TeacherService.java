package com.studentmanagenttask2.demo.services.teacher;

import com.studentmanagenttask2.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public void addTeacher(Teacher t);

    public void deleteTeacher(int id);

    public Teacher getTeacher(int id);

    public List<Teacher> getAll();

    public void updateTeacher(int id, Teacher t);
}
