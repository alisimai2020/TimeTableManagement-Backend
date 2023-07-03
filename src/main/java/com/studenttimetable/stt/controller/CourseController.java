package com.studenttimetable.stt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studenttimetable.stt.modal.Course;
import com.studenttimetable.stt.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
@GetMapping("/coursecount")
public ResponseEntity<Long> countCourse() {
    long userCount = courseService.countcourse();
    return new ResponseEntity<>(userCount, HttpStatus.OK);
}
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourses(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.OK);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getallCourse();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
        course.setId(id);
        Course courseUpdate = courseService.updateClassroom(course);
        return new ResponseEntity<>(courseUpdate, HttpStatus.OK);
    }
}
