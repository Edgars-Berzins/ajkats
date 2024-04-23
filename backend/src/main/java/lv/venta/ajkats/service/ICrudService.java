package lv.venta.ajkats.service;

import lv.venta.ajkats.dto.BaseEntityDTO;
import lv.venta.ajkats.models.BaseEntity;
import java.util.List;


public interface ICrudService<T extends BaseEntity, D extends BaseEntityDTO> {

    T create(T entity);

    T retrieveById(Long id) throws Exception;

    List<D> retrievePage(int page, int size);

    List<D> retrieveAll();

    T updateById(Long id, T entity) throws Exception;

    void deleteById(Long id) throws Exception;

    T convertToEntity(D dto);

    D convertToDto(T entity);
}
