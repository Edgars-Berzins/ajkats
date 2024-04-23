package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.ExamStudentDTO;
import lv.venta.ajkats.models.entities.ExamStudent;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IExamStudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam-student")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExamStudentController extends CrudController<ExamStudent, ExamStudentDTO> {

    private final IExamStudentService examStudentService;

    @Override
    protected ICrudService<ExamStudent, ExamStudentDTO> crudService() {
        return examStudentService;
    }
}
