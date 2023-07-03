package com.studenttimetable.stt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studenttimetable.stt.modal.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional custom query methods can be added here if needed
    Course findByName(String name);
}
