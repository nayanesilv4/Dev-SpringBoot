package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("João Pedro", "Oliveira"));
        theStudents.add(new Student("Nayane", "Costa"));
        theStudents.add(new Student("Agatha", "Oliveira-Costa"));

    }


    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent (@PathVariable int studentId){

        if ((studentId >= theStudents.size()) || (studentId < 0)){

            throw new StudentNotFoundException("Id de aluno não encontrado -  " + studentId);

        }

        return theStudents.get(studentId);
    }


}
