package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.*;
import lv.venta.ajkats.models.enums.LevelOfStudy;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO extends BaseEntityDTO {

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    @Size(min = 3, max = 30)
    private String surname;

    @NotNull
    @Size(min = 8, max = 20)
    @Pattern(regexp = "[0-9]{8,20}")
    private String matriculationNumber;

    @Valid
    @JsonIgnore
    private Collection<Course> courses = new ArrayList<>();

    @Valid
    @JsonIgnore
    private Collection<ExamStudent> examStudents = new ArrayList<>();


}
