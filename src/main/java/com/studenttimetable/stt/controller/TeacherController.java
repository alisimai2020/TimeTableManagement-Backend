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

import com.studenttimetable.stt.modal.teacher;
import com.studenttimetable.stt.service.TeacherService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

@GetMapping("/teachercount")
public ResponseEntity<Long> countTeacher() {
    long userCount = teacherService.countTeacher();
    return new ResponseEntity<>(userCount, HttpStatus.OK);
}

    @PostMapping("/teacher")
    public ResponseEntity<teacher> createTeacher(@RequestBody teacher Teacher) {
        teacher savedTeacher= teacherService.createTeacher(Teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.OK);
    }


    @GetMapping("/teacher")
    public List<teacher> getAllteacher(){
        return  teacherService.getallteacher();

    }


    @GetMapping("/teacher/{id}")
    public ResponseEntity<teacher>  getTeacherId(@PathVariable Long id) {
        teacher Teacher = teacherService.getTeacherById(id);
         return new ResponseEntity<>(Teacher, HttpStatus.OK);
    }


    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    @PutMapping("/teacher/{id}")
    public ResponseEntity<teacher> updateTeacher(@PathVariable("id") long id, @RequestBody teacher Teacher) {
        Teacher.setId(id);;
        teacher Teacherupdate = teacherService.updateTeacher(Teacher);
        return new ResponseEntity<>(Teacherupdate, HttpStatus.OK);
    }

   
    
}
