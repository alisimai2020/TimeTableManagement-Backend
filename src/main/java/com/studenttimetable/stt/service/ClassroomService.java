package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Classroom;
import com.studenttimetable.stt.repository.ClassroomRepository;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

public Classroom Createclassromm(Classroom classroom) {
    return classroomRepository.save(classroom);
}

public List<Classroom> getAllClassrooms() {
    return classroomRepository.findAll();
}



public void deleteClassroom(Long id) {
    classroomRepository.deleteById(id);
}

public Classroom updateClassroom(Classroom classroom) {

    Classroom updateclassroom = classroomRepository.findById(classroom.getId()).get();
    updateclassroom.setCapacity(classroom.getCapacity());
    updateclassroom.setNumber(classroom.getNumber());
    return classroomRepository.save(updateclassroom);
}

public Classroom getClassroomById(Long id) {

    Optional<Classroom> classroom =classroomRepository.findById(id);
    return  classroom.get();
}

}

