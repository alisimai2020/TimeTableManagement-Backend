package com.studenttimetable.stt.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studenttimetable.stt.modal.Classroom;
import com.studenttimetable.stt.service.ClassroomService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
@RequestMapping("/api/v1")
public class ClassroomController {

@Autowired
private ClassroomService classroomService;


            @PostMapping("/room")
            public ResponseEntity<Classroom> createclassromm(@RequestBody Classroom classroom) {
                Classroom savedClassroom = classroomService.Createclassromm(classroom);
                return new ResponseEntity<>(savedClassroom, HttpStatus.OK);
            }


            @GetMapping("/room")
            public List<Classroom> getAllclassroom(){
                return  classroomService.getAllClassrooms();

            }


            @GetMapping("/room/{id}")
            public ResponseEntity<Classroom>  getClassroomById(@PathVariable Long id) {
                Classroom classroom = classroomService.getClassroomById(id);
                 return new ResponseEntity<>(classroom, HttpStatus.OK);
            }


            @DeleteMapping("/room/{id}")
            public ResponseEntity<String> deleteClassroom(@PathVariable Long id) {
                classroomService.deleteClassroom(id);
                return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
            }

        
            @PutMapping("/room/{id}")
            public ResponseEntity<Classroom> updateUser(@PathVariable("id") long id, @RequestBody Classroom classroom) {
                classroom.setId(id);;
                Classroom classroomdate = classroomService.updateClassroom(classroom);
                return new ResponseEntity<>(classroomdate, HttpStatus.OK);
            }



    
}
