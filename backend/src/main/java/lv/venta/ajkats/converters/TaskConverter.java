package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.TaskDTO;
import lv.venta.ajkats.models.entities.Task;

public class TaskConverter implements IDtoConverter<Task, TaskDTO> {

    public Task convertToEntity(TaskDTO dto) {
        final Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTaskDescription(dto.getTaskDescription());
        entity.setMaximumPoints(dto.getMaximumPoints());
        dto.getExamResults().forEach(entity::addExamResult);

        return entity;
    }

    public TaskDTO convertToDto(Task entity) {
        final TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTaskDescription(entity.getTaskDescription());
        dto.setMaximumPoints(entity.getMaximumPoints());
        dto.setExamResults(entity.getExamResults());

        return dto;
    }
}
