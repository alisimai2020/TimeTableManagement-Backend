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

import com.studenttimetable.stt.modal.User;
import com.studenttimetable.stt.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserService userService;


@GetMapping("/user/count")
public ResponseEntity<Long> countUsers() {
    long userCount = userService.countUsers();
    return new ResponseEntity<>(userCount, HttpStatus.OK);
}

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
 

    @GetMapping("/user")
    public List<User> getAllteacher(){
        return  userService.getAllUser();

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User>  getTeacherId(@PathVariable Long id) {
        User user = userService.getUserById(id);
         return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        user.setId(id);
        User Userupdate = userService.updateUser(user);
        return new ResponseEntity<>(Userupdate, HttpStatus.OK);
    }


   
}
