package com.studenttimetable.stt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.modal.User;
import com.studenttimetable.stt.repository.UserRepository;
import com.studenttimetable.stt.service.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

     @Autowired
    private UserService userService;


     @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User userLogin = userRepository.findUserByUsername(user.getUsername());

        if (userLogin != null && passwordEncoder.matches(user.getPassword(), userLogin.getPassword())) {
            // Retrieve the role name using role ID from the user
            String roleName = userRepository.findRoleNameById(userLogin.getRole().getId());

            return new ResponseEntity<>(roleName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

//     @PostMapping("/login")
// public ResponseEntity<User> login(@RequestBody User user) {
//     User userLogin = userRepository.findUserByUsername(user.getUsername());

    
//     if (userLogin != null && passwordEncoder.matches(user.getPassword(), userLogin.getPassword())) {
//          Role role = userLogin.getRole(); // Retrieve the role of the logged-in user
//         return new ResponseEntity<>(userLogin, HttpStatus.OK);
//     } else {
//         return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//     }

// @PostMapping("/login")
// public String login(@RequestBody User user) {
//     Role role =user.getRole(); // Retrieve the role based on your business logic
//     User storedUser = userRepository.findByUsernameAndRole(user.getUsername(), role);
//     if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
//         return "Login successful!";
//     } else {
//         return "Invalid username or password";
//     }
// }


   

    @DeleteMapping("/logout")
    public String logout() {
        // session.invalidate();
        return "Logged out successfully!";
    }
}
