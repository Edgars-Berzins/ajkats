package lv.venta.ajkats.dto;

import lombok.Getter;
import lombok.Setter;
import lv.venta.ajkats.models.interfaces.IDto;

@Getter
@Setter
public class BaseEntityDTO implements IDto {
    private long id;
}
