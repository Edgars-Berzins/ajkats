package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;

@Table(name = "exam_results_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamResult extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @NotNull(message = "EXAM RESULT requires POINTS!")
    @Column(name = "EarnedPoints")
//    @NotBlank
    private float earnedPoints;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_exam_student")
    @NotNull
    private ExamStudent examStudent;

    @ManyToOne
    @JoinColumn(name = "id_task")
    @NotNull
    private Task task;

    //----------------------------------------------------METHODS----------------------------------------------------

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public ExamResult(float earnedPoints, ExamStudent examStudent, Task task) {
        this.earnedPoints = earnedPoints;
        this.examStudent = examStudent;
        this.task = task;
    }
}
