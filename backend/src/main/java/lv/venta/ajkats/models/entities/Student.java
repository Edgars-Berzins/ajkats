package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;

import java.util.*;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @NotNull
    @Column(name = "Name")
//    @NotBlank
//    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "NAME must start with a CAPITAL LETTER!")
    @Size(min = 3, max = 30)
    private String name;

    @Column(name = "Surname")
//    @NotBlank
//    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "SURNAME must start with a CAPITAL LETTER!")
    @Size(min = 3, max = 30)
    private String surname;

    @Column(name = "MatriculationNumber")
    @NotNull(message = "STUDENT requires a MATRICULATION NUMBER!")
    @Size(min = 8, max = 20)
    @Pattern(regexp = "[0-9]{8,20}")
    private String matriculationNumber;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @ManyToMany
    @JoinTable(name = "student_course_table", joinColumns = @JoinColumn(name = "id_student"), inverseJoinColumns = @JoinColumn(name = "id_course"))
    private Collection<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private Collection<ExamStudent> examStudents;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addExamStudent(ExamStudent examStudent) {
        if (!examStudents.contains(examStudent)) {
            examStudents.add(examStudent);
        }
    }

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public Student(String name, String surname, String matriculationNumber) {
        this.name = name;
        this.surname = surname;
        this.matriculationNumber = matriculationNumber;
        this.courses = new ArrayList<>();
        this.examStudents = new ArrayList<>();
    }
}
