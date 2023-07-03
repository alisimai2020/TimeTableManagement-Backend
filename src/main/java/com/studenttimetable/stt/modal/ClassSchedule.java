package com.studenttimetable.stt.modal;


import java.time.LocalTime;

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
@Table(name="ClassSchedule_tb")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class ClassSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
     private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public ClassSchedule(String day, LocalTime startTime, LocalTime endTime, Course course, Classroom classroom) {
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
            this.course = course;
            this.classroom = classroom;
        }
}
