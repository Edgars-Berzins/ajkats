package lv.venta.ajkats.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.models.BaseEntity;
import lv.venta.ajkats.models.enums.*;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "study_program_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudyProgram extends BaseEntity {

    //---------------------------------------------------VARIABLES---------------------------------------------------
    @Column(name = "StudyProgramTitleLv")
    @Size(min = 3, max = 30)
    @NotNull
//    @NotBlank
    private String studyProgramTitleLv;

    @Column(name = "Faculty")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "STUDY PROGRAM requires a FACULTY!")
    private Faculty faculty;

    @Column(name = "LevelOfStudy")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "STUDY PROGRAM requires a LEVEL OF STUDY!")
    private LevelOfStudy levelOfStudy;

    @Column(name = "Language")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "STUDY PROGRAM requires a LANGUAGE!")
    private StudyLanguage studyLanguage;

    //---------------------------------------------------LINKAGES----------------------------------------------------
    @OneToMany(mappedBy = "studyProgram")
    private Collection<Course> courses;

    //----------------------------------------------------METHODS----------------------------------------------------
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    //--------------------------------------------------CONSTRUCTORS-------------------------------------------------
    public StudyProgram(String studyProgramTitleLv, Faculty faculty, LevelOfStudy levelOfStudy, StudyLanguage studyLanguage) {
        this.studyProgramTitleLv = studyProgramTitleLv;
        this.faculty = faculty;
        this.levelOfStudy = levelOfStudy;
        this.studyLanguage = studyLanguage;
        this.courses = new ArrayList<>();
    }
}