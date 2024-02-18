package lv.venta.ajkats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.ajkats.model.enums.LevelOfStudy;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idc")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idc;

    @Column(name = "Title")
    @Size(min = 3, max = 25)
    @NotNull
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
    private String title;

    @Column(name = "CreditPoints")
    @NotNull
    @Min(value = 1)
    @Max(value = 20)
    private int creditPoints;

    @Column(name = "LevelOfStudy")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "STUDY PROGRAM REQUIRES A LEVEL OF STUDY!")
    private LevelOfStudy levelOfStudy;


    public Course(String title, int creditPoints, LevelOfStudy levelOfStudy) {
        this.title = title;
        this.creditPoints = creditPoints;
        this.levelOfStudy = levelOfStudy;
    }
}
