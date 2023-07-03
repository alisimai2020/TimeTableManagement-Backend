package com.studenttimetable.stt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studenttimetable.stt.modal.ClassSchedule;

import com.studenttimetable.stt.service.ClassscheduleService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClassscheduleController{

    @Autowired
    private ClassscheduleService classscheduleService;

    @PostMapping("/classshedule")
   public ResponseEntity<String> createClassSchedule(@RequestBody ClassSchedule classSchedule) {
        try {
            classscheduleService.saveSchedule(classSchedule);
            return ResponseEntity.ok("Class schedule created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create class schedule.");
        }
    }


    @GetMapping("/classshedule")
    public List<ClassSchedule> getAllschedule(){
        return classscheduleService.gettAllSchedule();
    }

    @GetMapping("/classshedule/{id}")
    public ResponseEntity<ClassSchedule> getScheduleById(@PathVariable("id") Long id){
        ClassSchedule scheduleId = classscheduleService.gettAllScheduleByID(id);
        return new ResponseEntity<>(scheduleId, HttpStatus.OK);
   
    }


    @DeleteMapping("/classshedule/{id}")
    public ResponseEntity<String> deleteschedule(@PathVariable Long id ){
        classscheduleService.deleteSchedule(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);

    }


    @PutMapping("/classshedule/{id}")
    public ResponseEntity<ClassSchedule> updateUser(@PathVariable("id") long id, @RequestBody ClassSchedule classSchedule) {
        classSchedule.setId(id);;
        ClassSchedule classscheduleupdate = classscheduleService.updateClassSchedule(classSchedule);
        return new ResponseEntity<>(classscheduleupdate, HttpStatus.OK);
    }

      @GetMapping("/timetable")
    public ResponseEntity<List<ClassSchedule>> getTimetableByDay(@RequestParam("day") String day) {
        List<ClassSchedule> timetable = classscheduleService.getTimetableByDay(day);
        return ResponseEntity.ok(timetable);
    }
}

