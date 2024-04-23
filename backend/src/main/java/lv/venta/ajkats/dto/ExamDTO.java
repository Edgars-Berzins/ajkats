package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.Course;
import lv.venta.ajkats.models.entities.ExamStudent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class ExamDTO extends BaseEntityDTO{

    @NotNull
    private String examTitle;

    @NotNull
    private LocalDateTime examDate;

    @Valid
    @JsonIgnore
    private Course course;

    @Valid
    @JsonIgnore
    private Collection<ExamStudent> examStudents = new ArrayList<>();

}
