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


import com.studenttimetable.stt.modal.Department;

import com.studenttimetable.stt.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DepartmetController {
    @Autowired
    private DepartmentService departmentService;



    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment= departmentService.CreateDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }


    @GetMapping("/department")
    public List<Department> getAlldepartment(){
        return  departmentService.getallDepartment();

    }


    @GetMapping("/department/{id}")
    public ResponseEntity<Department>  getDepartmentyId(@PathVariable Long id) {
        Department Department = departmentService.getDepartmentById(id);
         return new ResponseEntity<>(Department, HttpStatus.OK);
    }


    @DeleteMapping("/department/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department department) {
        department.setId(id);
        Department Departmentupdate = departmentService.UpdateDepartment(department);
        return new ResponseEntity<>(Departmentupdate, HttpStatus.OK);
    }
   
}
