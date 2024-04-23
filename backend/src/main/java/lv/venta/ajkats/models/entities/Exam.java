package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "exam_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exam extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @NotNull
    @Column(name = "ExamTitle")
//    @NotBlank
//    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "Exam TITLE must start with a CAPITAL LETTER!")
    private String examTitle;

    @Column(name = "ExamDate")
    private LocalDateTime examDate;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_course")
    @NotNull(message = "EXAM requires a COURSE!")
    private Course course;

    @OneToMany(mappedBy = "exam")
    private Collection<ExamStudent> examStudents;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addExamStudent(ExamStudent examStudent) {
        if (!examStudents.contains(examStudent)) {
            examStudents.add(examStudent);
        }
    }
    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public Exam(String examTitle, Course course) {
        this.examTitle = examTitle;
        this.examDate = LocalDateTime.now();
        this.course = course;
        this.examStudents = new ArrayList<>();
    }
}
