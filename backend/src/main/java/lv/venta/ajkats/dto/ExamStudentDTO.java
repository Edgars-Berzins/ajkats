package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.Exam;
import lv.venta.ajkats.models.entities.ExamResult;
import lv.venta.ajkats.models.entities.Student;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class ExamStudentDTO extends BaseEntityDTO {

    @Valid
    @JsonIgnore
    private Student student;

    @Valid
    @JsonIgnore
    private Exam exam;

    @Valid
    @JsonIgnore
    private Collection<ExamResult> examResults = new ArrayList<>();


}
