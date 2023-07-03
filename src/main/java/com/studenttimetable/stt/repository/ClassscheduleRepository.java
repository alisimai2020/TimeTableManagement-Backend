package com.studenttimetable.stt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studenttimetable.stt.modal.ClassSchedule;

public interface ClassscheduleRepository extends  JpaRepository<ClassSchedule,Long> {
    List<ClassSchedule> findByDay(String day);
     
}
