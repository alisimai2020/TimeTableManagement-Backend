package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.modal.Student;
import com.studenttimetable.stt.modal.StudentCourse;
import com.studenttimetable.stt.modal.User;
import com.studenttimetable.stt.modal.Year;
import com.studenttimetable.stt.repository.CourseRepository;
import com.studenttimetable.stt.repository.RoleRepository;
import com.studenttimetable.stt.repository.StudentCourseRepository;
import com.studenttimetable.stt.repository.StudentRepository;
import com.studenttimetable.stt.repository.UserRepository;

@Service
public class studentService {
    @Autowired
    private StudentRepository studentRepository;

     @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  RoleRepository roleRepository;
    
    @Autowired
    private  StudentCourseRepository studentCourseRepository;

       @Autowired
    private  CourseRepository  courseRepository;



    @Autowired
   PasswordEncoder passwordEncoder;

      public long countStudent() {
        return studentRepository.count();
    }

    public Student updateStudent(Student student) {
        Student updatestudent = studentRepository.findById(student.getId()).get();
        updatestudent.setName(student.getName());
        updatestudent.setAddress(student.getAddress());
        updatestudent.setPhoneNumber(student.getPhoneNumber());
        updatestudent.setEmail(student.getEmail());
        updatestudent.setYear(student.getYear());
        return studentRepository.save(updatestudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getstudentById(Long id) {
        Optional<Student> program =studentRepository.findById(id);
    return  program.get();
    }

    public List<Student> getallstudent() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
  
         Student studentsave = studentRepository.save(student);
        // Find the role with the name "teacher" or create it if not found
        Role teacherRole = roleRepository.findById(3L).orElse(null);
        if (teacherRole == null) {
            teacherRole = new Role();
            teacherRole.setRoleName("teacher");
            teacherRole = roleRepository.save(teacherRole);
        }

         // Create a new user
        User user = new User();
        String encPsd = this.passwordEncoder.encode(studentsave.getAddress());
        user.setUsername(studentsave.getEmail()); // Set the default username
        user.setPassword(encPsd); // Set the password as desired
        user.setStatus("underprocess"); // Set the status as desired
         // Set the teacher ID as the user ID
        // user.setId(savedTeacher.getId());
   
        user.setRole(teacherRole); // Set the teacher role

        return studentsave;
    }
    
public Student createstudentWithCourse(Student studentData) {
    // Create a new student
    Student student = new Student();
    student.setName(studentData.getName());
    student.setAddress(studentData.getAddress());
    student.setPhoneNumber(studentData.getPhoneNumber());
    student.setEmail(studentData.getEmail());

    // Set the year based on the year ID
    Year year = new Year();
    year.setId(studentData.getYear().getId());
    student.setYear(year);
    studentRepository.save(student);

    // Get the student ID
    Long studentId = student.getId();

   

    // Create the student course
    StudentCourse studentCourse = new StudentCourse();
    
    studentCourse.setStudent(student);
    // studentCourse.setCourse(course);
    studentCourse.setStatus("Enrolled");
    studentCourseRepository.save(studentCourse);

    return student;
}

}
