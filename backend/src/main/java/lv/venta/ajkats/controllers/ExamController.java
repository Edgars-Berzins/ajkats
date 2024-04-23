package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.ExamDTO;
import lv.venta.ajkats.models.entities.Exam;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IExamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController extends CrudController<Exam, ExamDTO> {

    private final IExamService examService;

    @Override
    protected ICrudService<Exam, ExamDTO> crudService() {
        return examService;
    }
}
