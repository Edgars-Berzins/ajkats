package lv.venta.ajkats.converters;

import lv.venta.ajkats.models.interfaces.IDto;
import lv.venta.ajkats.models.interfaces.IEntity;

public interface IDtoConverter<T extends IEntity, D extends IDto> {

    T convertToEntity(D dto);

    D convertToDto(T entity);

}
