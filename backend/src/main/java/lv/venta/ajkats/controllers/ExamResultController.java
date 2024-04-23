package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.ExamResultDTO;
import lv.venta.ajkats.models.entities.ExamResult;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IExamResultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam-result")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExamResultController extends CrudController<ExamResult, ExamResultDTO> {

    private final IExamResultService examResultService;

    @Override
    protected ICrudService<ExamResult, ExamResultDTO> crudService() {
        return examResultService;
    }
}
