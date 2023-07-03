package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.modal.User;
import com.studenttimetable.stt.modal.teacher;
import com.studenttimetable.stt.repository.RoleRepository;
import com.studenttimetable.stt.repository.TeacherRepository;
import com.studenttimetable.stt.repository.UserRepository;

@Service
public class TeacherService {
    @Autowired
    private  TeacherRepository teacherRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  RoleRepository roleRepository;
@Autowired
   PasswordEncoder passwordEncoder;
   


      public long countTeacher() {
        return teacherRepository.count();
    }

public teacher createTeacher(teacher Teacher) {
    // Save the teacher data
    teacher savedTeacher = teacherRepository.save(Teacher);

    // Find the role with the name "teacher" or create it if not found
    Role teacherRole = roleRepository.findById(1L).orElse(null);
    if (teacherRole == null) {
        teacherRole = new Role();
        teacherRole.setRoleName("teacher");
        teacherRole = roleRepository.save(teacherRole);
    }

    // Create a new user
        User user = new User();
        String encPsd = this.passwordEncoder.encode(savedTeacher.getTeachername());
        user.setUsername(savedTeacher.getEmail()); // Set the default username
        user.setPassword(encPsd); // Set the password as desired
        user.setStatus("underprocess"); // Set the status as desired
     // Set the teacher ID as the user ID
        // user.setId(savedTeacher.getId());
   
        user.setRole(teacherRole); // Set the teacher role

                  
                
   

    // Save the user data
    userRepository.save(user);

    return savedTeacher;
}


    public List<teacher> getallteacher() {
        return teacherRepository.findAll();
    }

    public teacher getTeacherById(Long id) {
        Optional<teacher> teach = teacherRepository.findById(id);
        return teach.orElse(null);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public teacher updateTeacher(teacher Teacher) {
        teacher updatesteacher = teacherRepository.findById(Teacher.getId()).orElse(null);
        if (updatesteacher != null) {
            updatesteacher.setTeachername(Teacher.getTeachername());
            updatesteacher.setPhoneNo(Teacher.getPhoneNo());
            updatesteacher.setEmail(Teacher.getEmail());
            updatesteacher.setAddress(Teacher.getAddress());
            updatesteacher.setDepartment(Teacher.getDepartment());
            return teacherRepository.save(updatesteacher);
        }
        return null;
    }
}