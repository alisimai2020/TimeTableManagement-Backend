package com.studenttimetable.stt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studenttimetable.stt.modal.Student;

import com.studenttimetable.stt.service.studentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class studentController {
    @Autowired
    private studentService studentservice;

@GetMapping("/studentcount")
public ResponseEntity<Long> countUsers() {
    long userCount = studentservice.countStudent();
    return new ResponseEntity<>(userCount, HttpStatus.OK);
}

@PostMapping("/create")
public ResponseEntity<Student> createStudentWithCourse(@RequestBody Student student) {
    Student savedStudent = studentservice.createstudentWithCourse(student);
    return new ResponseEntity<>(savedStudent, HttpStatus.OK);
}



    @PostMapping("/student")
    public ResponseEntity<Student> createstudent(@RequestBody Student student) {
        Student savedCourse= studentservice.createStudent(student);
        return new ResponseEntity<>(savedCourse, HttpStatus.OK);
    }


    @GetMapping("/student")
    public List<Student> getAllclassroom(){
        return  studentservice.getallstudent();

    }


    @GetMapping("/student/{id}")
    public ResponseEntity<Student>  getCourseyId(@PathVariable Long id) {
        Student student = studentservice.getstudentById(id);
         return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentservice.deleteStudent(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        student.setId(id);
        Student updatedstudent = studentservice.updateStudent(student);
        if (updatedstudent != null) {
            return new ResponseEntity<>(updatedstudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
