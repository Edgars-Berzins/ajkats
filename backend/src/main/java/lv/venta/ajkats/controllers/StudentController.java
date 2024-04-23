package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.StudentDTO;
import lv.venta.ajkats.models.entities.Student;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.IStudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController extends CrudController<Student, StudentDTO> {

    private final IStudentService studentService;

    @Override
    protected ICrudService<Student, StudentDTO> crudService() {
        return studentService;
    }
}
