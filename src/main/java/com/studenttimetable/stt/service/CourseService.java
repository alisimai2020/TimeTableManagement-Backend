package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Course;
import com.studenttimetable.stt.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

          public long countcourse() {
        return courseRepository.count();
    }

    public Course createCourses(Course course) {
        return courseRepository.save(course);
    }

    public Course updateClassroom(Course course) {
        Course coursseupdate = courseRepository.findById(course.getId()).get();

        coursseupdate.setProgram(course.getProgram());
        coursseupdate.setName(course.getName());
         coursseupdate.setCode(course.getCode());
      
        
       
    
        return courseRepository.save(coursseupdate);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


    public Course getCourseById(Long id) {
        Optional<Course> CoursefindByID = courseRepository.findById(id);
    
    return CoursefindByID.get();
    }

    public List<Course> getallCourse() {
        return courseRepository.findAll();
    }


   
    
    
}
