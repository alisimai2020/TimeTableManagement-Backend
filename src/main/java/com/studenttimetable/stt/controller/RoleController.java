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

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.service.RoleService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RoleController {
    @Autowired
    private RoleService roleService;



    @PostMapping("/role")
    public ResponseEntity<Role> createCourse(@RequestBody Role role) {
        Role savedRole= roleService.createRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.OK);
    }


    @GetMapping("/role")
    public List<Role> getAllclassroom(){
        return  roleService.getallCourse();

    }


    @GetMapping("/role/{id}")
    public ResponseEntity<Role>  getCourseyId(@PathVariable Long id) {
        Role course = roleService.getRoleById(id);
         return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateCourse(@PathVariable("id") long id, @RequestBody Role role) {
        role.setId(id);
        Role programupdate = roleService.updateRole(role);
        return new ResponseEntity<>(programupdate, HttpStatus.OK);
    }

    
}
