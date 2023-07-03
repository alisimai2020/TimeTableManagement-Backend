package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.ClassSchedule;
import com.studenttimetable.stt.modal.Course;
import com.studenttimetable.stt.repository.ClassscheduleRepository;
import com.studenttimetable.stt.repository.CourseRepository;

@Service
public class ClassscheduleService {
   @Autowired
   private ClassscheduleRepository classscheduleRepository;
  @Autowired
    private CourseRepository courseRepository;
  public void saveSchedule(ClassSchedule classSchedule) {
        Course course = classSchedule.getCourse();
        if (course.getId() == null) {
            courseRepository.save(course);
        }
        classscheduleRepository.save(classSchedule);
    }

public List<ClassSchedule> gettAllSchedule() {
    return classscheduleRepository.findAll();
}

public ClassSchedule gettAllScheduleByID(Long id) {
    Optional<ClassSchedule> classscOptional = classscheduleRepository.findById(id);
    
    return classscOptional.get();
}

public void  deleteSchedule(Long id) {
    classscheduleRepository.deleteById(id);
   
}

public ClassSchedule updateClassSchedule(ClassSchedule classSchedule) {

    ClassSchedule classupdate = classscheduleRepository.findById(classSchedule.getId()).get();
     classupdate.setDay(classSchedule.getDay());
    classupdate.setCourse(classSchedule.getCourse());
    classupdate.setClassroom(classSchedule.getClassroom());
   

    return classscheduleRepository.save(classupdate);

    
}

public List<ClassSchedule> getTimetableByDay(String day) {
        return classscheduleRepository.findByDay(day);
    }

  
}
