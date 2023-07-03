package com.studenttimetable.stt.modal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="year_tb")
@Setter
@Getter

@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year_name;


    public Year(String yearName) {
        this.year_name = yearName;
    }

   


}
