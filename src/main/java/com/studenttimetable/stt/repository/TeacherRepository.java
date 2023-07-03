package com.studenttimetable.stt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studenttimetable.stt.modal.teacher;

@Repository
public interface TeacherRepository extends JpaRepository<teacher, Long> {
    // Additional custom query methods can be added here if needed
}
