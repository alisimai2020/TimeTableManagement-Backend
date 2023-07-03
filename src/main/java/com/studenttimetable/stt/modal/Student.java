package com.studenttimetable.stt.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="student_tb")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Student {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
     private String email;

 

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;


    public Student(Long id) {
        this.id = id;
    }
}
