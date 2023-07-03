package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Department;
import com.studenttimetable.stt.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;



    public Department CreateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getallDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department =departmentRepository.findById(id);
        return  department.get();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department UpdateDepartment(Department department) {
        Department updatedepartment = departmentRepository.findById(department.getId()).get();
        updatedepartment.setName(department.getName());
        // updatedepartment.setPrograms(department.getPrograms());
        return departmentRepository.save(updatedepartment);
    }
   
}
