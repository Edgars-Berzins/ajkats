package lv.venta.ajkats.models;

import jakarta.persistence.*;
import lombok.*;
import lv.venta.ajkats.models.interfaces.IEntity;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements IEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}