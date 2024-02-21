package com.studentmanagenttask2.demo.controller;

import com.studentmanagenttask2.demo.entity.Course;
import com.studentmanagenttask2.demo.entity.Quiz;
import com.studentmanagenttask2.demo.entity.Teacher;
import com.studentmanagenttask2.demo.services.quiz.QuizService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
@RequestMapping("/api/quiz")

public class QuizController {
    private QuizService QS;
    @Autowired
    public QuizController(QuizService QS) {
        this.QS = QS;
    }

    @PostMapping("/addquiz")
    public ResponseEntity<String> addQuiz(@RequestBody Quiz q ){
        QS.addQuiz(q);
        return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable int id){
        return new ResponseEntity<>(QS.getQuiz(id),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity <List<Quiz>> getAllQuizzes(){
        return new ResponseEntity<>(QS.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/deletequiz/{id}")

    public ResponseEntity<String> deleteQuiz(@PathVariable int id){
        QS.deleteQuiz(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/updatequiz/{id}")
    public ResponseEntity<String> updateQuiz(@PathVariable int id,@RequestBody Quiz q){
        QS.updateQuiz(id,q);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }

    @GetMapping("/pavequizzes")
    public String saveCourse(Model m){
        Quiz q=new Quiz();
        m.addAttribute("quiz",q);
        return "quizshowform";
    }

    @GetMapping("/su")
    public String SuccessCourse(@ModelAttribute("quiz") Quiz q, BindingResult theBindingResult){

        if(theBindingResult.hasErrors()){
            System.out.println("lk");
            return "quizshowform";
        }

        else{
            //Teacher t=TS.getTeacher(id);
            QS.addQuiz(q);
            return "quizsucessform";
        }
    }

}
