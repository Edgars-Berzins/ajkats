package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.StudyProgramDTO;
import lv.venta.ajkats.models.entities.StudyProgram;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IStudyProgramService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study-program")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudyProgramController extends CrudController<StudyProgram, StudyProgramDTO> {

    private final IStudyProgramService studyProgramService;

    @Override
    protected ICrudService<StudyProgram, StudyProgramDTO> crudService() {
        return studyProgramService;
    }
}
