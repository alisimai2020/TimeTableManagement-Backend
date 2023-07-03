package com.studenttimetable.stt.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.studenttimetable.stt.modal.StudentCourse;

import com.studenttimetable.stt.repository.CourseRepository;
import com.studenttimetable.stt.repository.RoleRepository;
import com.studenttimetable.stt.repository.StudentCourseRepository;
import com.studenttimetable.stt.repository.StudentRepository;
import com.studenttimetable.stt.repository.UserRepository;

@Service
public class StudentcourseService {
   
    // Constructors, getters, and setters
    @Autowired
    private  StudentCourseRepository studentCourseRepository;
     @Autowired
    private StudentRepository studentRepository;

     @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  RoleRepository roleRepository;

    @Autowired
   PasswordEncoder passwordEncoder;

    @Autowired
        private CourseRepository courseRepository;
    public StudentCourse createCourse(StudentCourse studentprogramcourse) {
       
        return studentCourseRepository.save(studentprogramcourse);
    }

    //    public StudentCourse createcourseStudent(StudentCourse studentprogramcourse) {
    //     // Create a new student
    //     Student student = new Student();
    //     student.setName(studentprogramcourse.getStudent().getName());
    //     student.setAddress(studentprogramcourse.getStudent().getAddress());
    //     student.setPhoneNumber(studentprogramcourse.getStudent().getPhoneNumber());
    //     student.setEmail(studentprogramcourse.getStudent().getEmail());

    //     // Set the year based on the year ID
    //     Year year = new Year();
    //     year.setId(studentprogramcourse.getStudent().getYear().getId());
    //     student.setYear(year);
    //     studentRepository.save(student);
       
    //     // Set the student in the student program course
    //     studentprogramcourse.setStudent(student);

    //     return studentCourseRepository.save(studentprogramcourse);
    // }
   
   
   
   
    public StudentCourse getCourseById(Long id) {
        Optional<StudentCourse> Studentcourse =studentCourseRepository.findById(id);
        return  Studentcourse.get();
    }

    public StudentCourse updateStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public void deleteCourse(Long id) {
        studentCourseRepository.deleteById(id);
    }

    public List<StudentCourse> getallCourse() {
        return studentCourseRepository.findAll();
    }
}
