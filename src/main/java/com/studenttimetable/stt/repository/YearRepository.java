package com.studenttimetable.stt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studenttimetable.stt.modal.Year;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {
    // Additional custom query methods can be added here if needed
}
