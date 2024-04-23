package lv.venta.ajkats.service;

import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.dto.BaseEntityDTO;
import lv.venta.ajkats.models.BaseEntity;
import lv.venta.ajkats.repositories.IBaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class CrudServiceImplementation<T extends BaseEntity, D extends BaseEntityDTO> implements ICrudService<T, D> {

    protected abstract IBaseRepository<T, Long> getRepository();

    protected abstract IDtoConverter<T, D> getConverter();

    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T retrieveById(Long id) throws Exception {
        return getRepository().findById(id).orElseThrow(() -> new Exception("Entity not found"));
    }

    @Override
    public List<D> retrievePage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        final Page<T> entitiesPage = getRepository().findAll(pageable);
        return entitiesPage.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<D> retrieveAll() {
        final List<T> entitiesList = (List<T>) getRepository().findAll();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public T updateById(Long id, T entity) throws Exception {
        if (getRepository().existsById(id)) {
            entity.setId(id);
            return getRepository().save(entity);
        } else {
            throw new Exception("Entity not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
        } else {
            throw new Exception("Entity not found");
        }
    }

    @Override
    public D convertToDto(T entity) {
        return getConverter().convertToDto(entity);
    }

    @Override
    public T convertToEntity(D dto) {
        return getConverter().convertToEntity(dto);
    }
}