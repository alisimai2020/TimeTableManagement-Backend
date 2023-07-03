package com.studenttimetable.stt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studenttimetable.stt.modal.Year;
import com.studenttimetable.stt.repository.YearRepository;

@Service
public class YearService {
    @Autowired
    private YearRepository yearRepository;

    public Year createYear(Year year) {
        return yearRepository.save(year);
    }

    public List<Year> getallYear() {
        return yearRepository.findAll();
    }

    public Year getYearById(Long id) {
        Optional<Year> year =yearRepository.findById(id);
        return  year.get();
    }

    public void deleteYear(Long id) {
        yearRepository.deleteById(id);
    }

    public Year updateYear(Year year) {
        Year updatesyear = yearRepository.findById(year.getId()).get();
        updatesyear.setYear_name(year.getYear_name());
        return yearRepository.save(updatesyear);
    }


}
