package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.converters.TaskConverter;
import lv.venta.ajkats.dto.TaskDTO;
import lv.venta.ajkats.models.entities.Task;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.ITaskRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation extends CrudServiceImplementation<Task, TaskDTO> implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    private final TaskConverter taskConverter = new TaskConverter();

    @Override
    protected IBaseRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    @Override
    protected IDtoConverter<Task, TaskDTO> getConverter() {
        return taskConverter;
    }
}
