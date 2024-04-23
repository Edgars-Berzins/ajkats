package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.StudyProgramDTO;
import lv.venta.ajkats.dto.TaskDTO;
import lv.venta.ajkats.models.entities.StudyProgram;
import lv.venta.ajkats.models.entities.Task;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IStudyProgramService;
import lv.venta.ajkats.service.interfaces.ITaskService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController extends CrudController<Task, TaskDTO> {

    private final ITaskService taskService;

    @Override
    protected ICrudService<Task, TaskDTO> crudService() {
        return taskService;
    }
}
