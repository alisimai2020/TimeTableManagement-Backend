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

import com.studenttimetable.stt.modal.Program;
import com.studenttimetable.stt.service.ProgramService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProgramController {
    @Autowired
    private ProgramService programService;




    @PostMapping("/program")
    public ResponseEntity<Program> createProgram(@RequestBody Program program) {
        Program savedProgram= programService.createProgram(program);
        return new ResponseEntity<Program>(savedProgram, HttpStatus.OK);
    }


    @GetMapping("/program")
    public List<Program> getAllprograms(){
        return  programService.getallProgram();

    }


    @GetMapping("/program/{id}")
    public ResponseEntity<Program>  getProgramyId(@PathVariable Long id) {
        Program program = programService.getProgramById(id);
         return new ResponseEntity<>(program, HttpStatus.OK);
    }


    @DeleteMapping("/program/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
        return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
    }


    @PutMapping("/program/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable("id") long id, @RequestBody Program program) {
        program.setId(id);;
        Program Programupdate = programService.updateClassroom(program);
        return new ResponseEntity<>(Programupdate, HttpStatus.OK);
    }

}
