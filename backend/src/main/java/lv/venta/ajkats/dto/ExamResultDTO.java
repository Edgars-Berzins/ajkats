package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.ExamStudent;
import lv.venta.ajkats.models.entities.Task;

@Getter
@Setter
@NoArgsConstructor
public class ExamResultDTO extends BaseEntityDTO{


    @NotNull
    private float earnedPoints;

    @Valid
    @JsonIgnore
    private ExamStudent examStudent;

    @Valid
    @JsonIgnore
    private Task task;

}
