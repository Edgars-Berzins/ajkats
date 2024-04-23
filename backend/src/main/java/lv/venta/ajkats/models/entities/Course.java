package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;
import lv.venta.ajkats.models.enums.LevelOfStudy;
import java.util.*;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @Column(name = "Title")
    @Size(min = 3, max = 25)
    @NotNull(message = "COURSE requires a TITLE!")
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ ]+", message = "COURSE TITLE MUST START WITH CAPITAL LETTER")
    private String title;

    @Column(name = "CreditPoints")
    @NotNull(message = "COURSE requires CREDIT POINTS!")
    @Min(value = 1)
    @Max(value = 20)
    private int creditPoints;

    @Column(name = "LevelOfStudy")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "COURSE requires a LEVEL OF STUDY!")
    private LevelOfStudy levelOfStudy;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @ManyToMany(mappedBy = "courses")
    private Collection<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private Collection<Exam> exams;

    @ManyToOne
    @JoinColumn(name = "id_study_program")
    @NotNull(message = "COURSE requires a  STUDY PROGRAM!")
    private StudyProgram studyProgram;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void addExam(Exam exam) {
        if (!exams.contains(exam)) {
            exams.add(exam);
        }
    }

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public Course(String title, int creditPoints, LevelOfStudy levelOfStudy, StudyProgram studyProgram) {
        this.title = title;
        this.creditPoints = creditPoints;
        this.levelOfStudy = levelOfStudy;
        this.studyProgram = studyProgram;

        this.students = new ArrayList<>();
        this.exams = new ArrayList<>();
    }
}
