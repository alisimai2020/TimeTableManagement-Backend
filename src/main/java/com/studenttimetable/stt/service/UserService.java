package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Role;
import com.studenttimetable.stt.modal.User;
import com.studenttimetable.stt.repository.RoleRepository;
import com.studenttimetable.stt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


       public long countUsers() {
        return userRepository.count();
    }
    
    public User findUserByUsernameAndPassword(String username, String password) {
        User loginUser = userRepository.findUserByUsernameAndPassword(username, password);
        return loginUser;
    }

  public User createUser(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    // Check if the role is a transient instance
    if (user.getRole() != null && user.getRole().getId() == null) {
        Role savedRole = roleRepository.save(user.getRole()); // Assuming you have a RoleRepository
        user.setRole(savedRole);
    }

    return userRepository.save(user);
}


    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            existingUser.setPassword(encodedPassword);
            existingUser.setStatus(user.getStatus());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }
        return null; // Or throw an exception indicating that the user was not found
    }
}
