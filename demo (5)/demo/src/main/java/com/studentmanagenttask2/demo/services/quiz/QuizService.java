package com.studentmanagenttask2.demo.services.quiz;

import com.studentmanagenttask2.demo.entity.Quiz;

import java.util.List;

public interface QuizService {
    public void addQuiz(Quiz q);

    public void deleteQuiz(int id);

    public Quiz getQuiz(int id);

    public List<Quiz> getAll();

    public void updateQuiz(int id, Quiz q);
}
