package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.ExamResult;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO extends BaseEntityDTO{


    @NotNull
    private String taskDescription;

    @Min(value = 1)
    @Max(value = 20)
    private float maximumPoints;

    @Valid
    @JsonIgnore
    private Collection<ExamResult> examResults = new ArrayList<>();

}
