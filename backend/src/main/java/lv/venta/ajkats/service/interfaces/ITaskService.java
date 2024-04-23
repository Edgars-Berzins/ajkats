package lv.venta.ajkats.service.interfaces;

import lv.venta.ajkats.dto.TaskDTO;
import lv.venta.ajkats.models.entities.Task;
import lv.venta.ajkats.service.ICrudService;
import java.util.List;

public interface ITaskService extends ICrudService<Task, TaskDTO> {

}
