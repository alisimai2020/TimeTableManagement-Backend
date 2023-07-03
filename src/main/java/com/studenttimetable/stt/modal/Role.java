package com.studenttimetable.stt.modal;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "role_tb")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
