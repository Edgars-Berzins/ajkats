package lv.venta.ajkats.controllers;

import jakarta.validation.Valid;
import lv.venta.ajkats.dto.BaseEntityDTO;
import lv.venta.ajkats.models.BaseEntity;
import lv.venta.ajkats.service.ICrudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public abstract class CrudController<T extends BaseEntity, D extends BaseEntityDTO> {

    protected abstract ICrudService<T, D> crudService();

    @GetMapping("/all/page")
    public Collection<D> getEntitiesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return crudService().retrievePage(page, size);
    }

    @GetMapping("/all")
    public Collection<D> getAllEntities() {
        return crudService().retrieveAll();
    }

    @GetMapping("/{id}")
    public D getEntity(@PathVariable long id) throws Exception {
        final T entity = crudService().retrieveById(id);
        return crudService().convertToDto(entity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public D createEntity(@RequestBody @Valid D dto) throws Exception {
        final T newEntity = crudService().convertToEntity(dto);
        final T createdEntity = crudService().create(newEntity);
        return crudService().convertToDto(createdEntity);
    }

    @PutMapping("/{id}")
    public D updateEntity(@RequestBody @Valid D dto, @PathVariable long id) throws Exception {
        if (id == dto.getId()) {
            final T newEntity = crudService().convertToEntity(dto);
            final T updatedEntity = crudService().updateById(id, newEntity);
            return crudService().convertToDto(updatedEntity);
        } else {
            throw new Exception("ID NOT FOUND");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable long id) throws Exception {
        crudService().deleteById(id);
    }

}
