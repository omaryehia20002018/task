package com.studentmanagenttask2.demo.services.quiz;

import com.studentmanagenttask2.demo.entity.Quiz;
import com.studentmanagenttask2.demo.repositry.quiz.QuizRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceImp implements QuizService{

    private QuizRepositry QR;

    @Autowired
    public QuizServiceImp(QuizRepositry QR) {
        this.QR = QR;
    }

    @Override
    public void addQuiz(Quiz q) {
        QR.save(q);
    }

    @Override
    public void deleteQuiz(int id) {
        QR.deleteById(id);

    }

    @Override
    public Quiz getQuiz(int id) {
        return QR.findById(id).get();
    }

    @Override
    public List<Quiz> getAll() {
        return QR.findAll();
    }

    @Override
    public void updateQuiz(int id, Quiz q) {
        Quiz qq=QR.findById(id).get();
        if(q.getCreationDate()!=null){
            qq.setCreationDate(q.getCreationDate());
        }

        if(q.getCreationDateTime()!=null){
            qq.setCreationDateTime(q.getCreationDateTime());
        }

        if(q.getEndDateTime()!=null){
            qq.setEndDateTime(q.getEndDateTime());
        }

        if(q.getName()!=null){
            qq.setName(q.getName());
        }
          QR.save(qq);
    }
}
