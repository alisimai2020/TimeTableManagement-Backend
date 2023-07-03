package com.studenttimetable.stt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods can be added here if needed
    // User findByUsername(String username);     
    //  User finduserByUsernameAndPassword(String username,String password);

    User findUserByUsername(String username);    
  
    User findUserByUsernameAndPassword(String username, String password);

    @Query("SELECT r.roleName FROM Role r WHERE r.id = :roleId")
    String findRoleNameById(Long roleId);


}
