package lv.venta.ajkats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Ids")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ids;

    @NotNull
    @Column(name = "Name")
    @NotBlank
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "NAME MUST START WITH A CAPITAL LETTER!")
    @Size(min = 3, max = 30)
    private String name;

    @Column(name = "Surname")
    @NotBlank
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ]+", message = "SURNAME MUST START WITH A CAPITAL LETTER!")
    @Size(min = 3, max = 30)
    private String surname;

    @Column(name = "MatriculaNumber")
    @NotNull
    @Size(min = 8, max = 20)
    @Pattern(regexp = "[0-9]{8,20}")
    private String matriculaNumber;

    public Student(String name, String surname, String matriculaNumber) {
        this.name = name;
        this.surname = surname;
        this.matriculaNumber = matriculaNumber;
    }
}
