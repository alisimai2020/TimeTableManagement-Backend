package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Program;
import com.studenttimetable.stt.repository.ProgramRepository;

@Service
public class ProgramService {
     
    @Autowired
    private ProgramRepository programRepository;

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public List<Program> getallProgram() {
        return programRepository.findAll();
    }

    public Program getProgramById(Long id) {
        Optional<Program> program =programRepository.findById(id);
        return  program.get();
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }

    public Program updateClassroom(Program program) {
        Program updateprogram = programRepository.findById(program.getId()).get();
        updateprogram.setName(program.getName());
     
        return programRepository.save(updateprogram);
    }
}
