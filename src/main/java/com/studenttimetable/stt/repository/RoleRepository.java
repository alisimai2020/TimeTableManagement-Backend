package com.studenttimetable.stt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.studenttimetable.stt.modal.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);

}
