package com.studenttimetable.stt.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.repository.RoleRepository;

@Service
public class RoleService {
    

    @Autowired
    private RoleRepository rolerepository;

    public Role createRole(Role role) {
        return rolerepository.save(role);
    }

    public List<Role> getallCourse() {
        return rolerepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> Role =rolerepository.findById(id);
        return  Role.get();
    }

    public void deleteRole(Long id) {
        rolerepository.deleteById(id);
    }

    public Role updateRole(Role role) {
        Role updateRole = rolerepository.findById(role.getId()).get();
        updateRole.setRoleName(role.getRoleName());
     
        return rolerepository.save(updateRole);
    }
}
