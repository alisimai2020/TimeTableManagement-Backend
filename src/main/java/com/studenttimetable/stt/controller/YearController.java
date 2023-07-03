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
import com.studenttimetable.stt.modal.Year;
import com.studenttimetable.stt.service.YearService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class YearController {
    
    @Autowired
    private YearService yearService;


    
            @PostMapping("/year")
            public ResponseEntity<Year> createYear(@RequestBody Year year) {
                Year savedyear= yearService.createYear(year);
                return new ResponseEntity<>(savedyear, HttpStatus.OK);
            }


            @GetMapping("/year")
            public List<Year> getAllclassroom(){
                return  yearService.getallYear();

            }


            @GetMapping("/year/{id}")
            public ResponseEntity<Year>  getCourseyId(@PathVariable Long id) {
                Year year = yearService.getYearById(id);
                 return new ResponseEntity<>(year, HttpStatus.OK);
            }


            @DeleteMapping("/year/{id}")
            public ResponseEntity<String> deleteYear(@PathVariable Long id) {
                yearService.deleteYear(id);
                return new ResponseEntity<String>("Successfully deleted ", HttpStatus.OK);
            }

        
            @PutMapping("/year/{id}")
            public ResponseEntity<Year> updateYear(@PathVariable("id") long id, @RequestBody Year year) {
                year.setId(id);
                Year yeareupdate = yearService.updateYear(year);
                return new ResponseEntity<>(yeareupdate, HttpStatus.OK);
            }

}
