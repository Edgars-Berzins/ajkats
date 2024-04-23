package lv.venta.ajkats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.entities.*;
import lv.venta.ajkats.models.enums.LevelOfStudy;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO extends BaseEntityDTO{

    @Size(min = 3, max = 25)
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ ]+", message = "COURSE TITLE MUST START WITH CAPITAL LETTER")
    private String title;

    @Min(value = 1)
    @Max(value = 20)
    private int creditPoints;

    @Enumerated(EnumType.STRING)
    private LevelOfStudy levelOfStudy;

    @Valid
    @JsonIgnore
    private StudyProgram studyProgram;

    @Valid
    @JsonIgnore
    private Collection<Student> students = new ArrayList<>();

    @Valid
    @JsonIgnore
    private Collection<Exam> exams = new ArrayList<>();


}
