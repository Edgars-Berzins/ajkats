package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;

@Table(name = "task_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @NotNull
    @Column(name = "TaskDescription")
//    @NotBlank
//    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "TASK must start with a CAPITAL LETTER!")
    private String taskDescription;

    @Column(name = "MaximumPoints")
    @Min(value = 1)
    @Max(value = 20)
    private float maximumPoints;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @OneToMany(mappedBy = "task")
    private Collection<ExamResult> examResults;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addExamResult(ExamResult examResult) {
        if (!examResults.contains(examResult)) {
            examResults.add(examResult);
        }
    }

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public Task(String taskDescription, float maximumPoints) {
        this.taskDescription = taskDescription;
        this.maximumPoints = maximumPoints;
        this.examResults = new ArrayList<>();
    }
}
