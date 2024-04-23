package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.ajkats.models.entities.Course;
import lv.venta.ajkats.models.enums.Faculty;
import lv.venta.ajkats.models.enums.LevelOfStudy;
import lv.venta.ajkats.models.enums.StudyLanguage;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class StudyProgramDTO extends BaseEntityDTO {


    @Size(min = 3, max = 30)
    @NotNull
    private String studyProgramTitleLv;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Faculty faculty;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LevelOfStudy levelOfStudy;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StudyLanguage studyLanguage;

    @Valid
    @JsonIgnore
    private Collection<Course> courses = new ArrayList<>();

}
