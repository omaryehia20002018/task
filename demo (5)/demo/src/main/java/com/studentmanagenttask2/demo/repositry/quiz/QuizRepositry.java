package com.studentmanagenttask2.demo.repositry.quiz;

import com.studentmanagenttask2.demo.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepositry extends JpaRepository<Quiz,Integer> {
}
