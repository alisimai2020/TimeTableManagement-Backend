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

import com.studenttimetable.stt.modal.StudentCourse;
import com.studenttimetable.stt.service.StudentcourseService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentcourseController {
   
    @Autowired
    private StudentcourseService studentcourseService;



    @PostMapping("/studentcouse")
    public ResponseEntity<StudentCourse> createCourse(@RequestBody StudentCourse studentprogramcourse) {
        StudentCourse savedCourse= studentcourseService.createCourse(studentprogramcourse);
        return new ResponseEntity<>(savedCourse, HttpStatus.OK);
    }

    // @PostMapping("/studentcreate")
    // public ResponseEntity<StudentCourse> createCourseStudent(@RequestBody StudentCourse studentprogramcourse) {
    //     StudentCourse savedCourse= studentcourseService.createcourseStudent(studentprogramcourse);
    //     return new ResponseEntity<>(savedCourse, HttpStatus.OK);
    // }



   


    @GetMapping("/studentcouse")
    public List<StudentCourse> getAllclassroom(){
        return  studentcourseService.getallCourse();

    }


    @GetMapping("/studentcouse/ {id}")
    public ResponseEntity<StudentCourse>  getCourseyId(@PathVariable Long id) {
        StudentCourse studentCourse = studentcourseService.getCourseById(id);
         return new ResponseEntity<>(studentCourse, HttpStatus.OK);
    }


    @DeleteMapping("/studentcouse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        studentcourseService.deleteCourse(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    
    @PutMapping("/studentcouse/{id}")
    public ResponseEntity<StudentCourse> updateCourse(@PathVariable("id") long id, @RequestBody StudentCourse studentCourse) {
        studentCourse.setId(id);
        StudentCourse updatedCourse = studentcourseService.updateStudentCourse(studentCourse);
        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
