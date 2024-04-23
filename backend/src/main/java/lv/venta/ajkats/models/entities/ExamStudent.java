package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;

@Table(name = "exam_student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamStudent extends BaseEntity {

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_student")
    @NotNull
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_exam")
    @NotNull
    private Exam exam;

    @OneToMany(mappedBy = "examStudent")
    private Collection<ExamResult> examResults;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addExamResult(ExamResult examResult) {
        if (!examResults.contains(examResult)) {
            examResults.add(examResult);
        }
    }

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public ExamStudent(Student student, Exam exam) {
        this.student = student;
        this.exam = exam;
        this.examResults = new ArrayList<>();
    }
}
